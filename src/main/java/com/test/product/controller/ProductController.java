package com.test.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.product.model.bean.Product;
import com.test.product.model.dto.ProductDto;
import com.test.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/show/all")
	public List<ProductDto> findAllProduct(){
		List<ProductDto> products = productService.findAll();
		return products;
	}
	
	@PostMapping("/add")
	public ProductDto addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
}
