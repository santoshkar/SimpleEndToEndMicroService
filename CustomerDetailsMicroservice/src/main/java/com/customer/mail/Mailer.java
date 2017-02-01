package com.customer.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * 
 * @author skar
 *
 */
@Component
public class Mailer {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail(String email){
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(email);
		mailMessage.setSubject("Registration");
		mailMessage.setText("User Created Successfully");
		
		mailSender.send(mailMessage);
	}
}
