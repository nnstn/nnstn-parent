package com.nnstn.demo.mq.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.nnstn.demo.mq.producer.param.MailParam;

/**
 * @描述：MQ消息生产者
 * @作者：wangjn_bj
 * @创建时间：
 * @版本号：
 */
@Service("mqProcucer")
public class MqProducer {
	@Autowired
	private JmsTemplate activeMqJmsTemplate;
	
	public void sendMessage(final MailParam mail){
		activeMqJmsTemplate.send(new MessageCreator(){
			public Message createMessage(Session session) throws JMSException{
				return session.createTextMessage(JSONObject.toJSONString(mail));
			}
		});
	}
	
}
