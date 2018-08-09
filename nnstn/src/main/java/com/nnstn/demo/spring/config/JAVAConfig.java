package com.nnstn.demo.spring.config;

import org.springframework.context.annotation.Bean;

import com.nnstn.demo.spring.controller.UserFunctionController;
import com.nnstn.demo.spring.service.UserFunctionService;


public class JAVAConfig {
	@Bean
	public UserFunctionService  userFunctionService() {
		return new UserFunctionService();
	}
	@Bean
	public UserFunctionController userFunctionController(){
		UserFunctionService userFunctionService = new UserFunctionService();
		UserFunctionController userFunctionController = new UserFunctionController();
		userFunctionController.setService(userFunctionService);
		return userFunctionController;
	}
}
