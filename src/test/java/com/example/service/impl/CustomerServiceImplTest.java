package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.example.dao.CustomerDao;
import com.example.domain.Customer;
import com.example.domain.Order;
import com.example.service.CustomerService;
import com.example.service.OrderService;

public class CustomerServiceImplTest {
	private CustomerService customerService;
	private CustomerDao customerDaoMock;
	private OrderService orderServiceMock;

	@Before
	public void setUp() {

		customerDaoMock = mock(CustomerDao.class);
		orderServiceMock = mock(OrderService.class);

		customerService = new CustomerServiceImpl(customerDaoMock,
				orderServiceMock);
	}

	@Test
	public void shouldCreateCustomer() {
		Customer expectedCustomer = new Customer("firstName", "lastName");

		when(customerDaoMock.create(expectedCustomer)).thenReturn(
				expectedCustomer);
		Customer actualCustomer = customerService.create(expectedCustomer);

		assertEquals(expectedCustomer, actualCustomer);
	}

	@Test
	public void shouldUpdateCustomer() {
		Customer expectedCustomer = new Customer("firstName", "lastName");
		String customerId = "11";
		expectedCustomer.setId(customerId);

		List<Order> orders = new ArrayList<Order>();
		Order order1 = new Order();
		Order order2 = new Order();
		orders.add(order1);
		orders.add(order2);

		when(orderServiceMock.getOrdersForCustomerId(customerId)).thenReturn(
				orders);

		when(orderServiceMock.update(order1)).thenReturn(new Order());
		when(orderServiceMock.update(order2)).thenReturn(new Order());

		when(customerDaoMock.update(expectedCustomer)).thenReturn(expectedCustomer) ;
		
		Customer actualCustomer = customerService.update(expectedCustomer);
		assertEquals(expectedCustomer, actualCustomer) ;

		verify(orderServiceMock, times(1)).update(order1);
		verify(orderServiceMock, times(1)).update(order2);

	}
}
