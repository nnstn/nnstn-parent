package com.nnstn.demo.spring.condition.cmd;

public class WindowListService implements SystemCmd{

	@Override
	public String showListCmd() {
		return "dir";
	}

}
