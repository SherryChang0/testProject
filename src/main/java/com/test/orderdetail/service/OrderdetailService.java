package com.test.orderdetail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.orderdetail.model.dao.OrderdetailRepository;

@Transactional
@Service
public class OrderdetailService {
	
	@Autowired
	private OrderdetailRepository orderdetailRepository;

	
}
