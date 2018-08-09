package com.pursuit.hadoop.test.hadooprpc.service;

import com.pursuit.hadoop.test.hadooprpc.protocol.IUserLoginService;

public class UserLoginServiceImpl implements IUserLoginService{

	@Override
	public String login(String name, String passwd) {
		
		return name + "logged in successfully...";
	}
	
	
	

}
