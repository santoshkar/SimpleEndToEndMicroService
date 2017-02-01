package com.customer.mail;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.customer.util.Constants;

/**
 * 
 * @author skar
 *
 */
@Component
@Lazy
public class Sender {
	
	@Autowired
	RabbitMessagingTemplate template;
	
	@Bean
	Queue queue(){
		return new Queue(Constants.QUEUE_NAME, false);
	}
	
	public void send(String message){
		template.convertAndSend(Constants.QUEUE_NAME, message);
	}
}
