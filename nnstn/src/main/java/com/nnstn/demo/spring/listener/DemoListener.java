package com.nnstn.demo.spring.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.nnstn.demo.spring.event.DemoEvent;
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

	@Override
	public void onApplicationEvent(DemoEvent event) {
		String msg = event.getMsg();
		System.out.println("bean listener接收消息:"+msg);
	}

}
