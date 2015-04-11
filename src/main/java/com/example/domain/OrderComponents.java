package com.example.domain;

import java.util.List;

public class OrderComponents {

	private String customerId;
	private List<String> productIds;

	public OrderComponents(String customerId, List<String> productIds) {
		super();
		this.customerId = customerId;
		this.productIds = productIds;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public List<String> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<String> productIds) {
		this.productIds = productIds;
	}

}
