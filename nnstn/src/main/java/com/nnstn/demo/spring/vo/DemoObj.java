package com.nnstn.demo.spring.vo;

public class DemoObj {
	private Long id;
	private String name;
	//jackson 对象和json转换时，需要使用空构造
	public DemoObj() {
		super();
	}
	public DemoObj(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "DemoObj [id=" + id + ", name=" + name + "]";
	}
	
}
