package com.nnstn.demo.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class RequestTimeInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Long starttime = System.currentTimeMillis();
		request.setAttribute("starttime", starttime);
		System.out.println("=======前置拦截");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Long starttime = (Long) request.getAttribute("starttime");
		request.removeAttribute("starttime");
		Long endtime = System.currentTimeMillis();
		Long handlertime =endtime-starttime;
		System.out.println("本次请求处理"+new Long(endtime-starttime));
		request.setAttribute("handlertime", handlertime);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("处理结束 afterCompletion");
	}

}
