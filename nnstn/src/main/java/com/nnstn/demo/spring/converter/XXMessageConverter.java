package com.nnstn.demo.spring.converter;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import com.nnstn.demo.spring.vo.DemoObj;

public class XXMessageConverter extends AbstractHttpMessageConverter<DemoObj> {

	public XXMessageConverter() {
		super(new MediaType("application", "x-wisely", Charset.forName("UTF-8")));
	}
	//处理请求数据
	@Override
	protected DemoObj readInternal(Class<? extends DemoObj> clazz,HttpInputMessage inputMessage) 
			throws IOException,HttpMessageNotReadableException {
		String temp = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
		String [] tempAttr = temp.split("-");
		return new DemoObj(new Long(tempAttr[0]),tempAttr[1]);
	}
	//表明 XXMessageConverter 只处理DemoObj这个类
	@Override
	protected boolean supports(Class<?> clazz) {
		return DemoObj.class.isAssignableFrom(clazz);
	}

	@Override
	protected void writeInternal(DemoObj obj, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		String out = "hello:"+obj.getId()+"-" + obj.getName();
		outputMessage.getBody().write(out.getBytes());
	}
	

}
