package com.example.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.example.dao.OrderDao;
import com.example.domain.Customer;
import com.example.domain.Order;
import com.example.domain.OrderComponents;
import com.example.domain.Product;
import com.example.exception.NotFoundException;
import com.example.service.CustomerService;
import com.example.service.OrderService;
import com.example.service.ProductService;

public class OrderServiceImplTest {

	private OrderService orderService;
	private OrderDao orderDaoMock;
	private CustomerService customerServiceMock;
	private ProductService productServiceMock;

	@Before
	public void setup() {
		orderDaoMock = mock(OrderDao.class);
		customerServiceMock = mock(CustomerService.class);
		productServiceMock = mock(ProductService.class);

		orderService = new OrderServiceImpl(orderDaoMock, customerServiceMock,
				productServiceMock);
	}

	@Test
	public void shouldThrowExceptionOnAttemptToCreateOrderWithIncorrectCustomerId() {
		String customerId = getCustomerId();
		List<String> productIds = new ArrayList<String>();

		OrderComponents orderComponents = new OrderComponents(customerId,
				productIds);

		when(customerServiceMock.getCustomerById(customerId)).thenReturn(null);
		try {
			orderService.create(orderComponents);
			fail("No Exception was thrown!");
		} catch (NotFoundException notFoundException) {
			assertTrue(true);
		}
	}

	@Test
	public void shouldThrowExceptionOnAttemptToCreateOrderWithIncorrectProductIds() {
		String customerId = getCustomerId();
		String productId1 = "22B";
		String productId2 = "33C";
		List<String> productIds = getProductIds(productId1, productId2);

		OrderComponents orderComponents = new OrderComponents(customerId,
				productIds);

		mockCustomerServiceCall(customerId);
		when(productServiceMock.getProductById(productId1)).thenReturn(null);
		try {
			orderService.create(orderComponents);
			fail("No Exception was thrown!");
		} catch (NotFoundException notFoundException) {
			assertTrue(true);
		}
		verify(productServiceMock).getProductById(productId1);
	}

	private List<String> getProductIds(String productId1, String productId2) {
		List<String> productIds = new ArrayList<String>();

		productIds.add(productId1);
		productIds.add(productId2);
		return productIds;
	}

	@Test
	public void shouldCreateOrder() {
		String customerId = getCustomerId();

		mockCustomerServiceCall(customerId);
		List<String> productIds = mockProductServiceCall();

		OrderComponents orderComponents = new OrderComponents(customerId,
				productIds);

		Order expectedOrder = new Order();
		when(orderDaoMock.create(any(Order.class))).thenReturn(expectedOrder);
		Order actualOrder = orderService.create(orderComponents);
		assertEquals(expectedOrder, actualOrder);
	}

	private String getCustomerId() {
		String customerId = "11A";
		return customerId;
	}

	private void mockCustomerServiceCall(String customerId) {
		when(customerServiceMock.getCustomerById(customerId)).thenReturn(
				new Customer("abc", "def"));
	}

	private List<String> mockProductServiceCall() {
		String productId1 = "22B";
		String productId2 = "33C";
		List<String> productIds = getProductIds(productId1, productId2);

		when(productServiceMock.getProductById(productId1)).thenReturn(
				new Product());
		when(productServiceMock.getProductById(productId2)).thenReturn(
				new Product());
		return productIds;
	}
}
