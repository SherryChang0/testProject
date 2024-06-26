package com.test.product.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import com.test.product.model.bean.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

	public static final JdbcTemplate jdbcTemplate = new JdbcTemplate();


}
