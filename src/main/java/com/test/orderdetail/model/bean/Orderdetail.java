package com.test.orderdetail.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.test.orders.model.bean.Orders;
import com.test.product.model.bean.Product;

@Entity
@Table(name = "orderdetail")
public class Orderdetail {

	@Id
	@Column(name = "orderItemSN")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderItemSN;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "standPrice")
	private Integer standPrice;
	
	@Column(name = "itemPrice")
	private Integer itemPrice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productId")
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderId")
	private Orders order;

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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

}
