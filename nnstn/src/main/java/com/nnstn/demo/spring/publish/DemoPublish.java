package com.nnstn.demo.spring.publish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.nnstn.demo.spring.event.DemoEvent;

@Component
public class DemoPublish {
	@Autowired
	ApplicationContext applicationContext;
	public void publish(String msg){
		System.out.println("执行publish："+msg);
		applicationContext.publishEvent(new DemoEvent(this, msg));
	}
}
