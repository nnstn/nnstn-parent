package com.nnstn.demo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
}
