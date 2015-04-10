package com.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.domain.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {
	Customer insert(Customer customer) ;
	List<Customer> findByFirstName(String firstName) ;
	Customer findById(String id) ;
	Long deleteCustomerById(String id);
}
