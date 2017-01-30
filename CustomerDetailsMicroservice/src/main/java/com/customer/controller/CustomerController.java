package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customer.CustomerRegistrar;
import com.customer.entity.Customer;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRegistrar customerRegister;
	
	@RequestMapping(path="register", method = RequestMethod.POST)
	public Customer register(@RequestBody Customer customer){
		return customerRegister.register(customer);
	}
}
