package com.test.orders.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.orders.model.bean.Orders;

public interface OrdersRepository extends JpaRepository<Orders, String>{

}
