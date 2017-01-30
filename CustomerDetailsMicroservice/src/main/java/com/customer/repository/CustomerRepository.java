package com.customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.customer.entity.Customer;

/**
 * 
 * @author skar
 *
 */
//@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	Optional<Customer> findByName(@Param("name") String name);

}
