package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CustomerDao;
import com.example.domain.Customer;
import com.example.domain.Order;
import com.example.service.CustomerService;
import com.example.service.OrderService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private OrderService orderService;

	public CustomerServiceImpl() {
	}

	public CustomerServiceImpl(CustomerDao customerDao,
			OrderService orderService) {
		this.customerDao = customerDao;
		this.orderService = orderService;
	}

	@Override
	public Customer create(Customer customer) {
		return customerDao.create(customer);
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
		List<Order> orders = orderService.getOrdersForCustomerId(customer
				.getId());
		if ((orders != null) && (orders.size() > 0)) {
			setCustomerInOrders(customer, orders);
			updateOrders(orders);
		}
		return customerDao.update(customer);
	}

	private void updateOrders(List<Order> orders) {
		for (Order order : orders) {
			orderService.update(order);
		}
	}

	private void setCustomerInOrders(Customer customer, List<Order> orders) {
		for (Order order : orders) {
			order.setCustomer(customer);
		}
	}

	@Override
	public Customer getCustomerById(String customerId) {
		return customerDao.getCustomerById(customerId);
	}

}
