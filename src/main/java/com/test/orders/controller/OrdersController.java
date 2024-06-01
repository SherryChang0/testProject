package com.test.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.orders.model.bean.Orders;
import com.test.orders.service.OrdersService;
import com.test.product.model.bean.Product;
import com.test.product.service.ProductService;

@Controller
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private ProductService productService;
	
    @GetMapping("/addOrder")
    public String listProducts(Model model) {
    	 List<Product> products = productService.getAllProducts();
         model.addAttribute("products", products);
        return "addOrder";
    }
    
    @GetMapping("/allOrder")
    public String listOrders(Model model) {
    	List<Orders> orders = ordersService.getAllOrders();
    	model.addAttribute("orders",orders);
    	return "allOrder";
    }
}
