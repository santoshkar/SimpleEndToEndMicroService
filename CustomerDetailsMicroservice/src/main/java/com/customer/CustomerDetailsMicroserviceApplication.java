package com.customer;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.customer.entity.Customer;
import com.customer.repository.CustomerRepository;

@SpringBootApplication
public class CustomerDetailsMicroserviceApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerDetailsMicroserviceApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... arg0) throws Exception {
		repo.save(new Customer("Santosh Kumar", "santosh@gmail.com"));
		repo.save(new Customer("Manas", "manas@gmail.com"));
		repo.save(new Customer("Rupali", "rupali@gmail.com"));
		repo.save(new Customer("Som", "som@gmail.com"));
		repo.save(new Customer("Titly", "titly@gmail.com"));
	}
}
