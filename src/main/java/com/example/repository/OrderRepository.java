package com.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.domain.Customer;
import com.example.domain.Order;

public interface OrderRepository extends MongoRepository<Order, Integer> {
	Order insert(Order order);

	List<Order> findByCustomer(Customer customer);

	Order findById(String orderId);

	Long deleteOrderById(String id);
}
