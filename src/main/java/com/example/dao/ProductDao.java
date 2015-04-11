package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.domain.Product;
import com.example.exception.NotFoundException;
import com.example.repository.ProductRepository;

@Component
public class ProductDao {

	@Autowired
	private ProductRepository productRepository;

	public ProductDao() {
	}

	public ProductDao(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Product create(Product product) {
		return productRepository.insert(product);
	}

	public List<Product> getProductsByName(String name) {
		return productRepository.findByName(name);
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Long deleteProductById(String id) {
		Product productFetchedFromDatastore = productRepository.findById(id);
		if (productFetchedFromDatastore == null) {
			throw new NotFoundException();
		} else {
			return productRepository.deleteProductById(id);
		}
	}

	public Product update(Product product) {
		Product productFetchedFromDatastore = productRepository
				.findById(product.getId());
		if (productFetchedFromDatastore == null) {
			throw new NotFoundException();
		}
		return productRepository.save(product);
	}

	public Product getProductById(String productId) {
		return productRepository.findById(productId);
	}

}
