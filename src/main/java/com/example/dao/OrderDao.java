package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.domain.Customer;
import com.example.domain.Order;
import com.example.exception.NotFoundException;
import com.example.repository.OrderRepository;

@Component
public class OrderDao {

	@Autowired
	private OrderRepository orderRepository;

	public OrderDao() {
	}

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
		Order orderFetchedFromDatastore = orderRepository.findById(id);
		if (orderFetchedFromDatastore == null) {
			throw new NotFoundException();
		} else {
			return orderRepository.deleteOrderById(id);
		}
	}

	public Order update(Order order) {
		Order orderFetchedFromDatastore = orderRepository.findById(order
				.getId());
		if (orderFetchedFromDatastore == null) {
			throw new NotFoundException();
		}
		return orderRepository.save(order);
	}

}
