package com.nnstn.demo.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nnstn.demo.spring.profile.DemoBean;


@Configuration
public class ProfileConfig {
	@Bean
//	@Profile(value = { "dev" })
	public DemoBean devDemoBean(){
		return new DemoBean("this is dev mode");
	}
	@Bean
//	@Profile(value = { "pro" })
	public DemoBean proDemoBean(){
		return new DemoBean("this is dev mode");
	}
}
