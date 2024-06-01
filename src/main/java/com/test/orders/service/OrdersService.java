package com.test.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.orders.model.bean.Orders;
import com.test.orders.model.dao.OrdersRepository;

@Transactional
@Service
public class OrdersService {

	@Autowired
	private OrdersRepository ordersRepository;

	public Orders insert(Orders orders) {
		return ordersRepository.save(orders);
	}
	
	public List<Orders> getAllOrders(){
		return ordersRepository.findAll();
	}
}
