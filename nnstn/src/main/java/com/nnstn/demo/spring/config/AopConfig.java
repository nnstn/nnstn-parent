package com.nnstn.demo.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.nnstn.demo.spring.service")
@EnableAspectJAutoProxy  //开启spring对AspectJ 的支持
public class AopConfig {

}
