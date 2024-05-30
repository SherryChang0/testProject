package com.test.orderdetail.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.orderdetail.model.bean.Orderdetail;

public interface OrderdetailRepository extends JpaRepository<Orderdetail,Integer>{

}
