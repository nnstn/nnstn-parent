package com.nnstn.demo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nnstn.demo.spring.vo.DemoObj;

@Controller
public class AdviceController {
	
	@RequestMapping("/advice")
	public String getSomething(@ModelAttribute("msg") String msg,DemoObj demoObj){
		System.out.println("demoObj:"+demoObj);
		throw new IllegalArgumentException("非常抱歉，参数有误/"+"来自@ModelAttribute:"+msg);
	}
}
