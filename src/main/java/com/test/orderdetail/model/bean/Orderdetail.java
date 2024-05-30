package com.test.orderdetail.model.bean;

import com.test.orders.model.bean.Orders;
import com.test.product.model.bean.Product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orderdetail")
public class Orderdetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderItemSN")
	private Integer orderItemSN;
	
	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="orderId")
	private Orders orders;
	
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productID")
	private Product productID;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "standPrice")
	private Integer standPrice;
	
	@Column(name = "itemPrice")
	private Integer itemPrice;
}
