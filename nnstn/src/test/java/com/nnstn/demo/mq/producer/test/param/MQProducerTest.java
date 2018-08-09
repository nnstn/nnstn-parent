package com.nnstn.demo.mq.producer.test.param;
  
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nnstn.demo.mq.producer.MqProducer;
import com.nnstn.demo.mq.producer.param.MailParam;

  
  
public class MQProducerTest {  
    private static final Log log = LogFactory.getLog(MQProducerTest.class);  
  
    @SuppressWarnings("resource")
	public static void main(String[] args) {  
        try {  
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");  
            context.start();  
  
            MqProducer mqProducer = (MqProducer) context.getBean("mqProducer");  
            // 邮件发送  
            MailParam mail = new MailParam();  
            mail.setTo("wangjn1130@163.com");  
            mail.setSubject("ActiveMQ测试");  
            mail.setContent("通过ActiveMQ异步发送邮件！");  
  
            mqProducer.sendMessage(mail);  
  
            context.stop();  
        } catch (Exception e) {  
            log.error("==>MQ context start error:", e);  
            System.exit(0);  
        } finally {  
            log.info("===>System.exit");  
            System.exit(0);  
        }  
    }  
} 
