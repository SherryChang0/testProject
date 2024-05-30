package com.test.product.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.product.model.bean.Product;
import com.test.product.model.dao.ProductRepository;
import com.test.product.model.dto.ProductDto;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<ProductDto> findAll() {
		List<Product> productList = productRepository.findAll();

		List<ProductDto> productDtos = productList.stream().map(p -> {
			ProductDto pd = new ProductDto();
			BeanUtils.copyProperties(p, pd);
			return pd;
		}).toList();

		return productDtos;
	}

	public ProductDto saveProduct(Product product) {
		Product newProduct = productRepository.save(product);
		ProductDto productDto = new ProductDto();
		BeanUtils.copyProperties(newProduct, productDto);

		return productDto;
	}

}
