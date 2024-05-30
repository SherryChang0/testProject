package com.test.orders.model.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
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
