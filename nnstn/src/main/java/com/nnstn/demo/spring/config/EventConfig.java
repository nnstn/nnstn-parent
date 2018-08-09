package com.nnstn.demo.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //声明当前类是一个配置类
@ComponentScan("com.nnstn.demo.spring.listener,com.nnstn.demo.spring.publish")
public class EventConfig {

}
