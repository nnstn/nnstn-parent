package com.nnstn.sso.service.impl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.nnstn.common.po.SsoUser;
import com.nnstn.common.utils.CookieUtils;
import com.nnstn.common.utils.JsonUtils;
import com.nnstn.common.vo.CommonResult;
import com.nnstn.sso.component.JedisClient;
import com.nnstn.sso.dao.SsoUserMapper;
import com.nnstn.sso.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private SsoUserMapper ssoUserMapper;
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${REDIS_SESSION_KEY}")
	private String REDIS_SESSION_KEY;
	@Value("${SESSION_EXPIRE}")
	private Integer SESSION_EXPIRE;
	
	@Override
	public CommonResult login(String username, String password,HttpServletRequest request, HttpServletResponse response) {
		//校验用户名密码是否正确

		SsoUser ssoUser = new SsoUser();
		ssoUser.setUsername(username);
		ssoUser.setPassword(password);
		
		List<SsoUser> list = ssoUserMapper.selectByCondition(ssoUser);
		//取用户信息
		if (list == null || list.isEmpty()) {
			return CommonResult.build(400, "用户名或密码错误");
		}
		SsoUser user = list.get(0);
		//校验密码
		if(!user.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
			return CommonResult.build(400, "用户名或密码错误");
		}
		//登录成功
		//生成token
		String token = UUID.randomUUID().toString();
		//把用户信息写入redis
		//key:REDIS_SESSION:{TOKEN}
		//value:user转json
		user.setPassword(null);
		jedisClient.set(REDIS_SESSION_KEY + ":" + token, JsonUtils.objectToJson(user));
		//设置session的过期时间
		jedisClient.expire(REDIS_SESSION_KEY + ":" + token, SESSION_EXPIRE);
		//写cookie
		CookieUtils.setCookie(request, response, "TT_TOKEN", token);
		return CommonResult.ok(token);
	}

	@Override
	public CommonResult getUserByToken(String token) {
		// 根据token取用户信息
		String json = jedisClient.get(REDIS_SESSION_KEY + ":" + token);
		//判断是否查询到结果
		if (StringUtils.isBlank(json)) {
			return CommonResult.build(400, "用户session已经过期");
		}
		//把json转换成java对象
		SsoUser user = JsonUtils.jsonToPojo(json, SsoUser.class);
		//更新session的过期时间
		jedisClient.expire(REDIS_SESSION_KEY + ":" + token, SESSION_EXPIRE);
		return CommonResult.ok(user);
	}
	@Override
	public CommonResult logout(String token) {
		//删除 用户信息
		jedisClient.del(REDIS_SESSION_KEY + ":" + token);
		return CommonResult.ok();
	}

}