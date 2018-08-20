package com.nnstn.sso.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nnstn.common.vo.CommonResult;

public interface LoginService {
	public CommonResult login(String username, String password,HttpServletRequest request, HttpServletResponse response);
	public CommonResult getUserByToken(String token);
	public CommonResult logout(String token);
}
