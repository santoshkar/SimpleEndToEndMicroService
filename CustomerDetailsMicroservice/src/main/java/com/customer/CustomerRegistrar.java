package com.customer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.customer.entity.Customer;
import com.customer.mail.Sender;
import com.customer.repository.CustomerRepository;

/**
 * 
 * @author skar
 *
 */
@Component
public class CustomerRegistrar {
	
	@Autowired
	private Sender sender;

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer register(Customer customer){
		Optional<Customer> existingCustomer = customerRepository.findByName(customer.getName());
		
		
		if(existingCustomer.isPresent()){
			throw new RuntimeException ("Customer with this name already exists");
		}else{
			customerRepository.save(customer);
			sender.send(customer.getEmail());
		}
		
		return customer;
	}
}

