package com.test.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.test.product.model.bean.Product;
import com.test.product.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/add")
	public String addProduct() {
		return "addProduct";
	}
	
	@PostMapping("addProduct")
	public String addProduct(@ModelAttribute("product")Product product) {
		productService.insert(product);
		return "redirect:/add";
	}
	
    @GetMapping("/allProduct")
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "allProduct";
    }
}
