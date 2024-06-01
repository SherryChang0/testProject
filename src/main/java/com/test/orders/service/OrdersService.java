package com.test.orders.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.orderdetail.model.bean.Orderdetail;
import com.test.orderdetail.model.dao.OrderdetailRepository;
import com.test.orders.model.bean.Orders;
import com.test.orders.model.dao.OrdersRepository;
import com.test.product.model.bean.Product;
import com.test.product.model.dao.ProductRepository;

@Transactional
@Service
public class OrdersService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private OrderdetailRepository orderdetailRepository;

	public List<Orders> getAllOrders() {
		return ordersRepository.findAll();
	}

	public List<Orderdetail> createOrderDetails(Map<String, String> params) {
		List<Orderdetail> orderDetails = new ArrayList<>();

		for (Map.Entry<String, String> entry : params.entrySet()) {
			if (entry.getKey().startsWith("quantity_")) {
				String productId = entry.getKey().substring(9);
				int quantity = Integer.parseInt(entry.getValue());
				Product product = productRepository.findById(productId).orElseThrow();

				Orderdetail detail = new Orderdetail();
				detail.setProduct(product);
				detail.setQuantity(quantity);
				detail.setStandPrice(product.getPrice());
				detail.setItemPrice(product.getPrice() * quantity);

				orderDetails.add(detail);
			}
		}
		return orderDetails;
	}

	public int calculateTotalAmount(List<Orderdetail> orderDetail) {
		int totalAmount = 0;
		for (Orderdetail detail : orderDetail) {
			totalAmount += detail.getItemPrice();
		}
		return totalAmount;
	}

	public Orders createOrder(List<Orderdetail> orderDetails) {
		Orders order = new Orders();
		order.setOrderDetails(orderDetails);
		order.setPrice(calculateTotalAmount(orderDetails));
		order.setPayStatus(false);
		ordersRepository.save(order);
		return order;
	}
	
    public void updateProductQuantities(List<Orderdetail> orderDetail) {
        for (Orderdetail detail : orderDetail) {
            Product product = detail.getProduct();
            product.setQuantity(product.getQuantity() - detail.getQuantity());
            productRepository.save(product);
        }
    }
}
