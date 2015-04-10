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

import com.example.domain.Order;
import com.example.domain.OrderComponents;
import com.example.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {

	private OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Order create(@RequestBody final OrderComponents orderComponents) {
		return orderService.create(orderComponents);
	}

	@RequestMapping(method = RequestMethod.GET, params="customerId")
	@ResponseBody
	public List<Order> getOrdersForCustomerId(@RequestParam final String customerId) {
		return orderService.getOrdersForCustomerId(customerId);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Long deleteOrder(@PathVariable("id") final String id) {
		return orderService.deleteOrderById(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public Order update(@RequestBody final Order order) {
		return orderService.update(order);
	}
	
}