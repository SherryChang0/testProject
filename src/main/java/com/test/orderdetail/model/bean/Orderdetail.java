package com.test.orderdetail.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetail")
public class Orderdetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderItemSN")
	private Integer orderItemSN;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "standPrice")
	private Integer standPrice;
	
	@Column(name = "itemPrice")
	private Integer itemPrice;

	public Integer getOrderItemSN() {
		return orderItemSN;
	}

	public void setOrderItemSN(Integer orderItemSN) {
		this.orderItemSN = orderItemSN;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getStandPrice() {
		return standPrice;
	}

	public void setStandPrice(Integer standPrice) {
		this.standPrice = standPrice;
	}

	public Integer getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}
	
}
