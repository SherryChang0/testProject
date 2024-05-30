package com.test.product.model.bean;

import java.util.List;

import com.test.orderdetail.model.bean.Orderdetail;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productID")
	private String productID;
	
	@Column(name = "productName")
	private String productName;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@OneToMany(mappedBy = "productID", cascade = CascadeType.ALL)
    private List<Orderdetail> orderDetail;
}
