package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CustomerDao;
import com.example.domain.Customer;
import com.example.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;

	@Autowired
	public CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public Customer create(Customer customer) {
		return customerDao.create(customer) ;
	}

	@Override
	public List<Customer> getCustomersByFirstName(String firstName) {
		return customerDao.getCustomersByFirstName(firstName);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

	@Override
	public Long deleteCustomerById(String id) {
		return customerDao.deleteCustomerById(id);
	}

	@Override
	public Customer update(Customer customer) {
		return customerDao.update(customer);
	}

	@Override
	public Customer getCustomerById(String customerId) {
		return customerDao.getCustomerById(customerId);
	}

}
