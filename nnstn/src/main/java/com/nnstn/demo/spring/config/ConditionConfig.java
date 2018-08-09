package com.nnstn.demo.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

import com.nnstn.demo.spring.condition.WindowsCondition;
import com.nnstn.demo.spring.condition.cmd.LinuxListService;
import com.nnstn.demo.spring.condition.cmd.SystemCmd;
import com.nnstn.demo.spring.condition.cmd.WindowListService;
import com.nnstn.demo.spring.conditiontion.LinuxtCondition;

public class ConditionConfig {
	@Bean
	@Conditional(WindowsCondition.class)
	public SystemCmd windowListService(){
		return new WindowListService();
	}
	@Bean
	@Conditional(LinuxtCondition.class)
	public SystemCmd linuxListService(){
		return new LinuxListService();
	}
}
