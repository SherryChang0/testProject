package com.test.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.product.model.bean.Product;
import com.test.product.model.dao.ProductRepository;

@Transactional
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product insert(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
}
