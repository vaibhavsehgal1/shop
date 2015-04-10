package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

@Component
public class CustomerDao {

	private CustomerRepository customerRepository;

	@Autowired
	public CustomerDao(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer create(Customer customer) {
		return customerRepository.insert(customer);
	}

	public List<Customer> getCustomersByFirstName(String firstName) {
		return customerRepository.findByFirstName(firstName);
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Long deleteCustomerById(String id) {
		return customerRepository.deleteCustomerById(id);
	}

	public Customer update(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer getCustomerById(String customerId) {
		return customerRepository.findById(customerId);
	}
}
