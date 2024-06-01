package com.test.orders.model.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.test.orderdetail.model.bean.Orderdetail;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@Column(name = "orderId")
	private String orderId;
	
	@Column(name = "memberId")
	private String memberId;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "payStatus")
	private Boolean payStatus;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orderdetail> orderDetails;
	
	public Orders() {
		
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Boolean getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Boolean payStatus) {
		this.payStatus = payStatus;
	}

	public List<Orderdetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<Orderdetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
}
