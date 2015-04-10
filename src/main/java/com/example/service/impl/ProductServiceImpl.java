package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ProductDao;
import com.example.domain.Product;
import com.example.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public Product create(Product product) {
		return productDao.create(product) ;
	}

	@Override
	public List<Product> getProductsByName(String name) {
		return productDao.getProductsByName(name);
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	@Override
	public Long deleteProductById(String id) {
		return productDao.deleteProductById(id);
	}

	@Override
	public Product update(Product product) {
		return productDao.update(product);
	}

	@Override
	public Product getProductById(String productId) {
		return productDao.getProductById(productId);
	}

}
