package com.pursuit.hadoop.test.hadooprpc.protocol;

public interface IUserLoginService {

	public static final long versionID = 100L;
	public String login(String name,String passwd);
	
}
