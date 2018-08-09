package com.pursuit.hadoop.test.hadooprpc.service;

import com.pursuit.hadoop.test.hadooprpc.protocol.ClientNamenodeProtocol;

public class MyNameNode implements ClientNamenodeProtocol{
	
	//模拟namenode的业务方法之一：查询元数据
	@Override
	public String getMetaData(String path){
		
		return path+": 3 - {BLK_1,BLK_2} ....";
		
	}
	

}
