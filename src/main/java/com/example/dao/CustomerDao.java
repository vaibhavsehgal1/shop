package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.domain.Customer;
import com.example.exception.NotFoundException;
import com.example.repository.CustomerRepository;

@Component
public class CustomerDao {

	@Autowired
	private CustomerRepository customerRepository;

	public CustomerDao() {
	}

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
		Customer customerFetchedFromDatastore = customerRepository.findById(id);
		if (customerFetchedFromDatastore == null) {
			throw new NotFoundException();
		} else {
			return customerRepository.deleteCustomerById(id);
		}
	}

	public Customer update(Customer customer) {
		Customer customerFetchedFromDatastore = customerRepository
				.findById(customer.getId());
		if (customerFetchedFromDatastore == null) {
			throw new NotFoundException();
		} else {
			return customerRepository.save(customer);
		}
	}

	public Customer getCustomerById(String customerId) {
		return customerRepository.findById(customerId);
	}
}
