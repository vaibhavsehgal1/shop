package com.example.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

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
		Customer expectedCustomer = getCustomer();

		when(customerDaoMock.create(expectedCustomer)).thenReturn(
				expectedCustomer);
		Customer actualCustomer = customerService.create(expectedCustomer);

		assertEquals(expectedCustomer, actualCustomer);
	}

	@Test
	public void shouldUpdateCustomer() {
		Customer expectedCustomer = getCustomer();
		String customerId = "11";

		List<Order> orders = new ArrayList<Order>();
		Order order1 = new Order();
		Order order2 = new Order();
		orders.add(order1);
		orders.add(order2);

		when(orderServiceMock.getOrdersForCustomerId(customerId)).thenReturn(
				orders);

		when(orderServiceMock.update(order1)).thenReturn(new Order());
		when(orderServiceMock.update(order2)).thenReturn(new Order());

		when(customerDaoMock.update(expectedCustomer)).thenReturn(
				expectedCustomer);

		Customer actualCustomer = customerService.update(expectedCustomer);
		assertEquals(expectedCustomer, actualCustomer);

		verify(orderServiceMock, times(1)).update(order1);
		verify(orderServiceMock, times(1)).update(order2);

	}

	@Test
	public void shouldUpdateCustomerEvenIfNoOrdersExistForIt() {
		Customer expectedCustomer = getCustomer();
		String customerId = "11";

		when(orderServiceMock.getOrdersForCustomerId(customerId)).thenReturn(
				null);
		
		when(customerDaoMock.update(expectedCustomer)).thenReturn(
				expectedCustomer);

		Customer actualCustomer = customerService.update(expectedCustomer);
		assertEquals(expectedCustomer, actualCustomer);
	}

	private Customer getCustomer() {
		Customer customer = new Customer("firstName", "lastName");
		String customerId = "11";
		customer.setId(customerId);
		return customer;
	}

}
