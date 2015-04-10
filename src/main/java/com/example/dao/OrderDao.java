package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.domain.Customer;
import com.example.domain.Order;
import com.example.repository.OrderRepository;

@Component
public class OrderDao {

	private OrderRepository orderRepository;

	@Autowired
	public OrderDao(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public Order create(Order order) {
		return orderRepository.insert(order);
	}

	public List<Order> getOrdersForCustomer(Customer customer) {
		return orderRepository.findByCustomer(customer);
	}

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Long deleteOrderById(String id) {
		return orderRepository.deleteOrderById(id);
	}

	public Order update(Order order) {
		return orderRepository.save(order);
	}

}
