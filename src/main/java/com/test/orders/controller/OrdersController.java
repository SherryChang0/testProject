package com.test.orders.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.orderdetail.model.bean.OrderForm;
import com.test.orderdetail.model.bean.Orderdetail;
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
	
    @GetMapping("/allOrder")
    public String listOrders(Model model) {
    	List<Orders> orders = ordersService.getAllOrders();
    	model.addAttribute("orders",orders);
    	return "allOrder";
    }
	
    @GetMapping("/addOrder")
    public String addOrdersForm(Model model) {
    	 List<Product> products = productService.getAllProducts();
         model.addAttribute("products", products);
        return "addOrder";
    }
    
    @PostMapping("/addOrder")
    public String addOrder(@RequestParam Map<String, String> params, Model model) {
        List<Orderdetail> orderDetail = ordersService.createOrderDetails(params);
        int totalAmount = ordersService.calculateTotalAmount(orderDetail);
        model.addAttribute("orderDetail", orderDetail);
        model.addAttribute("totalAmount", totalAmount);
        return "confirmOrder";
    }
    
    @ModelAttribute("orderDetail")
    public List<Orderdetail> getOrderDetail() {
        return new ArrayList<>();
    }
    
    @PostMapping("/confirmOrder")
    public String confirmOrder(@ModelAttribute("orderDetail") OrderForm orderForm, Model model) {
    	List<Orderdetail> orderDetails = orderForm.getOrderDetails();
    	Orders order = ordersService.createOrder(orderDetails);
        model.addAttribute("order", order);
        ordersService.updateProductQuantities(orderDetails);
        return "allOrder";
    }
}
