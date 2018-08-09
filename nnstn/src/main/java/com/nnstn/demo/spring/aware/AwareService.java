package com.nnstn.demo.spring.aware;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;


@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {
	String name;
	ResourceLoader resourceLoader;
	
	@Override
	public void setBeanName(String name) {
		this.name = name;
	}
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	public void outputResult(){
		System.out.println("Bean 的名称为："+name);
		System.out.println("resourceLoader 的名称为："+resourceLoader);
		Resource resource = resourceLoader.getResource("classpath:/aware.txt");
		try {
			System.out.println(IOUtils.toString(resource.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
