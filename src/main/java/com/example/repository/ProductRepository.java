package com.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.domain.Product;

public interface ProductRepository extends MongoRepository<Product, Integer> {
	Product insert(Product product);

	List<Product> findByName(String name);

	Long deleteProductById(String id);

	Product findById(String productId);
}
