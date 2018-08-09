package com.nnstn.demo.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nnstn.demo.spring.vo.DemoObj;

@Controller
@RequestMapping("/anno")
public class DemoAnnoController {
	@RequestMapping(produces="text/plain;charset=UTF-8") //没value 类级访问 http://localhost:8080/combat-spring/anno
	public @ResponseBody String index(HttpServletRequest request){
		return "url:"+request.getRequestURL()+ "can access";
	}
	@RequestMapping(value="/pathvar/{str}",produces="text/plain;charset=UTF-8")//路径做参数 http://localhost:8080/combat-spring/anno/pathvar/qqq
	public @ResponseBody String demoPathVar(HttpServletRequest request,@PathVariable String str){
		return "url:"+request.getRequestURL()+ "|" +str +"  |can access";
	}
	@RequestMapping(value="/pathvar/{str}/{num}",produces="text/plain;charset=UTF-8")//路径做参数 http://localhost:8080/combat-spring/anno/pathvar/qqq
	public @ResponseBody String demoTwoPathVar(HttpServletRequest request,@PathVariable String str,@PathVariable String num){
		System.out.println("不一样的参数");
		return "url:"+request.getRequestURL()+ "|" +str +"|" +num +"   |can access";
	}
	@RequestMapping(value="/requestParam",produces="text/plain;charset=UTF-8")//
	public @ResponseBody String requestParam(HttpServletRequest request,Long id){
		return "url:"+request.getRequestURL()+ "|" +id +"can access";
	}
	@RequestMapping(value="/requestDemo",produces="text/json;charset=UTF-8")//http://localhost:8080/combat-spring/anno/requestDemo?id=2&name=wangj
	@ResponseBody
	public String requestParam(HttpServletRequest request,DemoObj obj){
		return "url:"+request.getRequestURL()+ "|" +obj.getId()+ "|" +obj.getName() +"can access";
	}
	@RequestMapping(value={"name1","name2"},produces="text/plain;charset=UTF-8")
	public @ResponseBody String two(HttpServletRequest request){
		return "url:"+request.getRequestURL()+ "|"  +" two can access";
	}
}
