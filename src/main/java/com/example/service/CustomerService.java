package com.example.service;

import java.util.List;

import com.example.domain.Customer;

public interface CustomerService {

	Customer create(Customer customer);

	List<Customer> getCustomersByFirstName(String firstName);

	List<Customer> getAllCustomers();

	Long deleteCustomerById(String id);

	Customer update(Customer customer);

	Customer getCustomerById(String customerId);

}
