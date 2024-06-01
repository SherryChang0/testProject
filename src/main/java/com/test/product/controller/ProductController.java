package com.test.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	public ResponseEntity<String> addProduct(@ModelAttribute("product")Product product) {
	    if (product.getProductId() == null || product.getProductName() == null || product.getQuantity() == null) {
	        return ResponseEntity.badRequest().body("請填寫所有欄位！");
	    }
		productService.insert(product);
		return ResponseEntity.ok().body("新增商品成功！");
	}
	
    @GetMapping("/allProduct")
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "allProduct";
    }
}
