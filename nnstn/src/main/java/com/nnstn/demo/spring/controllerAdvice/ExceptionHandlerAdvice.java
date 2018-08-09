package com.nnstn.demo.spring.controllerAdvice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice //@ControllerAdvice 组合了@Component 主动注册spring 的bean
public class ExceptionHandlerAdvice {
	
	@ExceptionHandler(value=Exception.class) //过滤拦截条件，拦截所有Exception
	public ModelAndView exception(Exception exception,WebRequest request){
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errorMessage", exception.getMessage());
		return modelAndView;
	}
	@ModelAttribute
	public void addAttribute(Model model){
		model.addAttribute("msg", "额外信息");
	}
	@InitBinder //定制webDataBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.setDisallowedFields("id"); // 忽略request参数的 id
	}
}
