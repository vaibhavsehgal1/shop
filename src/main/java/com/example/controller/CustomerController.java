package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Customer;
import com.example.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Customer create(@RequestBody final Customer customer) {
		return customerService.create(customer);
	}

	@RequestMapping(method = RequestMethod.GET, params="firstname")
	@ResponseBody
	public List<Customer> getCustomersByFirstName(@RequestParam(value="firstname") final String firstName) {
		return customerService.getCustomersByFirstName(firstName);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Long deleteCustomer(@PathVariable("id") final String id) {
		return customerService.deleteCustomerById(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public Customer update(@RequestBody final Customer customer) {
		return customerService.update(customer);
	}
	
}