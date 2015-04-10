package com.example.service;

import java.util.List;

import com.example.domain.Product;

public interface ProductService {

	Product create(Product product);

	List<Product> getProductsByName(String name);

	List<Product> getAllProducts();

	Long deleteProductById(String id);

	Product update(Product product);

	Product getProductById(String productId);

}
