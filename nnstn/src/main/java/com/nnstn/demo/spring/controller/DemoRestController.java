package com.nnstn.demo.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nnstn.demo.spring.vo.DemoObj;

@RestController //@Controller和@ResponseBody组合
@RequestMapping("/rest")
public class DemoRestController {
	//http://localhost:8080/combat-spring/rest/getjson?id=2&name=wangj
	@RequestMapping(value="/getjson",produces="application/json;charset=UTF-8")
	public DemoObj getjson(DemoObj obj){
		return new DemoObj(obj.getId()+1, obj.getName()+"json");
	}
	//http://localhost:8080/combat-spring/rest/getxml?id=2&name=wangj
	@RequestMapping(value="/getxml",produces="application/xml;charset=UTF-8")
	public DemoObj getxml(DemoObj obj){
		return new DemoObj(obj.getId()+1, obj.getName()+"json");
	}
}
