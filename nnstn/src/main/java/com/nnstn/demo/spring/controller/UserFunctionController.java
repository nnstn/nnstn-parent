package com.nnstn.demo.spring.controller;

import com.nnstn.demo.spring.service.UserFunctionService;

public class UserFunctionController {

	UserFunctionService service;
	
	public void login(){
		System.out.println("i want to :"+service.login());
	}
	public void setService(UserFunctionService service) {
		this.service = service;
	}
}
