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

import com.example.domain.Product;
import com.example.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	public ProductController() {
	}
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Product create(@RequestBody final Product product) {
		return productService.create(product);
	}

	@RequestMapping(method = RequestMethod.GET, params="name")
	@ResponseBody
	public List<Product> getProductsByName(@RequestParam final String name) {
		return productService.getProductsByName(name);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Long deleteProduct(@PathVariable("id") final String id) {
		return productService.deleteProductById(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public Product update(@RequestBody final Product product) {
		return productService.update(product);
	}
	
}