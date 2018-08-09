package com.nnstn.demo.spring.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		//context.register(MVCConfigPlus.class);
		context.setServletContext(servletContext);
//		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
//		servlet.addMapping("/");
//		servlet.setLoadOnStartup(1);
	}

}
