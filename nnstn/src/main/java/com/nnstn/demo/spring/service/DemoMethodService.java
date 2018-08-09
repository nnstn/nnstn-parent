package com.nnstn.demo.spring.service;

import org.springframework.stereotype.Service;

@Service
public class DemoMethodService {
	public void add(){
		System.out.println("this is method aspect");
	}
}
