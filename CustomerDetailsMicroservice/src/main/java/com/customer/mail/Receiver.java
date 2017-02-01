package com.customer.mail;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.customer.util.Constants;

@Component
public class Receiver {
	
	@Autowired
	private Mailer mailer;
	
	@Bean
	Queue queue(){
		return new Queue(Constants.QUEUE_NAME, false);
	}
	
	@RabbitListener(queues = Constants.QUEUE_NAME)
	public void processMessage(String email){
		System.out.println(email);
		mailer.sendMail(email);
	}
}
