package com.test.orders.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderId")
	private String orderId;
	
	@Column(name = "memberId")
	private String memberId;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "payStatus")
	private Boolean payStatus;
}
