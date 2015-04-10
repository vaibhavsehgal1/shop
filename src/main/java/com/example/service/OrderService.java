package com.example.service;

import java.util.List;

import com.example.domain.Order;
import com.example.domain.OrderComponents;

public interface OrderService {

	Order create(OrderComponents orderComponents);

	List<Order> getOrdersForCustomerId(String customerId);

	List<Order> getAllOrders();

	Long deleteOrderById(String id);

	Order update(Order order);

}
