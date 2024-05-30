package com.test.product.model.dto;

import lombok.Data;

@Data
public class ProductDto {

	private String productID;
	private String productName;
	private Integer price;
	private Integer quantity;
}
