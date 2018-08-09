package com.nnstn.demo.spring.condition.cmd;

public class LinuxListService implements SystemCmd{

	@Override
	public String showListCmd() {
		return "ls";
	}

}
