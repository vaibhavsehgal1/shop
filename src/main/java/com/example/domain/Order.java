package com.example.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Order {

	@Id
	private String id;
	private Customer customer;
	private List<Product> products;

	public Order() {
	}
	
	public Order(Customer customer, List<Product> products) {
		super();
		this.customer = customer;
		this.products = products;
	}




	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}