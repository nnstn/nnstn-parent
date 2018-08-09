package com.nnstn.demo.spring.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.nnstn.demo.spring.converter.XXMessageConverter;
import com.nnstn.demo.spring.interceptor.RequestTimeInterceptor;


@Configuration
@EnableWebMvc //开启Spring MVC 支持
@ComponentScan("com.nnstn.demo.spring")
public class MVCConfigPlus extends WebMvcConfigurerAdapter {
	
	@Bean
	public RequestTimeInterceptor getRequestTimeInterceptor(){
		return new RequestTimeInterceptor();
	}
	@Bean
	public MultipartResolver multipartResolver(){
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxInMemorySize(1000000);
		return multipartResolver;
	}
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new 
				InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
		
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//addResourceHandler 文件放置目录 | addResourceLocations 对外暴露访问路径
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getRequestTimeInterceptor());
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) { //控制访问映射
		registry.addViewController("/hello/contro")  //浏览器 访问路径
		.setViewName("/index");	//页面实际路径
		
		registry.addViewController("/toUpload").setViewName("/upload");
		registry.addViewController("/converter").setViewName("/converter");
	}

//	@Override
//	public void configurePathMatch(PathMatchConfigurer configurer) {
//		configurer.setUseSuffixPatternMatch(false);
//	}
//	@Override
//	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//		converters.add(new XXMessageConverter());
//	}
	
	
	
}
