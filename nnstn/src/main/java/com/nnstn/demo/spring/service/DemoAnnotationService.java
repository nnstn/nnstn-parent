package com.nnstn.demo.spring.service;

import org.springframework.stereotype.Service;

import com.nnstn.demo.spring.annotation.Action;
@Service
public class DemoAnnotationService {
	@Action(name="这个是一个name")
	public void add(){
		System.out.println("this is annontation method");
	}
}
