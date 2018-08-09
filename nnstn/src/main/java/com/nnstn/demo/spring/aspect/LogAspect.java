package com.nnstn.demo.spring.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.nnstn.demo.spring.annotation.Action;

@Aspect //1.注解生成一个切面
@Component //2.spring 管理的bean
public class LogAspect {
	@Pointcut("@annotation(com.nnstn.demo.spring.annotation.Action)")//3.注解声明切点
	public void annotationPointCut(){
		System.out.println("注解声明切点");
	}
	@After("annotationPointCut()")
	public void after(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method = signature.getMethod();
		Action annotation = method.getAnnotation(Action.class);
		System.out.println("注解是拦截after："+ annotation.name());
	}
	@Before("execution(* com.nnstn.demo.spring.service.DemoMethodService.*(..))")
	public void before(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("方法规则式拦截before："+ method.getName());
	}
}
