package com.nnstn.sso.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nnstn.common.utils.ExceptionUtil;
import com.nnstn.common.vo.CommonResult;
import com.nnstn.sso.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/sso/login", method=RequestMethod.POST)
	public CommonResult login(String username, String password,HttpServletRequest request, HttpServletResponse response) {
		try {
			CommonResult result = loginService.login(username, password, request, response);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	@RequestMapping("/user/token/{token}")
	public Object getUserByToken(@PathVariable String token, String callback) {
		try {
			CommonResult result = loginService.getUserByToken(token);
			//支持jsonp调用
			if (StringUtils.isNotBlank(callback)) {
				MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
				mappingJacksonValue.setJsonpFunction(callback);
				return mappingJacksonValue;
			}
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

	@RequestMapping(value="/user/logout/{token}", method=RequestMethod.POST)
	public CommonResult login(@PathVariable String token) {
		try {
			CommonResult result = loginService.logout(token);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}
