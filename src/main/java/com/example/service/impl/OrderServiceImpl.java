package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.OrderDao;
import com.example.domain.Customer;
import com.example.domain.Order;
import com.example.domain.OrderComponents;
import com.example.domain.Product;
import com.example.service.CustomerService;
import com.example.service.OrderService;
import com.example.service.ProductService;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao;
	private CustomerService customerService;
	private ProductService productService;

	@Autowired
	public OrderServiceImpl(OrderDao orderDao, CustomerService customerService,
			ProductService productService) {
		this.orderDao = orderDao;
		this.customerService = customerService;
		this.productService = productService;
	}

	@Override
	public Order create(OrderComponents orderComponents) {
		String customerId = orderComponents.getCustomerId();
		Customer customer = customerService.getCustomerById(customerId);
		List<Product> products = new ArrayList<Product>();

		List<String> productIds = orderComponents.getProductIds();
		for (String productId : productIds) {
			products.add(productService.getProductById(productId));
		}

		Order order = new Order(customer, products);

		return orderDao.create(order);
	}

	@Override
	public List<Order> getOrdersForCustomerId(String customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		return orderDao.getOrdersForCustomer(customer);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderDao.getAllOrders();
	}

	@Override
	public Long deleteOrderById(String id) {
		return orderDao.deleteOrderById(id);
	}

	@Override
	public Order update(Order order) {
		return orderDao.update(order);
	}

}
