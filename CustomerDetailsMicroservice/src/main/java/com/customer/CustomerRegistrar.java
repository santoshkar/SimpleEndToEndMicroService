package com.customer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.customer.entity.Customer;
import com.customer.repository.CustomerRepository;

@Component
public class CustomerRegistrar {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer register(Customer customer){
		Optional<Customer> existingCustomer = customerRepository.findByName(customer.getName());
		
		
		if(existingCustomer.isPresent()){
			throw new RuntimeException ("Customer with this name already exists");
		}else{
			customerRepository.save(customer);
		}
		
		return customer;
	}
}

