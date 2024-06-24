package com.joe.nespresso_ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joe.nespresso_ecommerce.entity.Product;
import com.joe.nespresso_ecommerce.service.ProductService;


@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("product")
    public String getMethodName(@RequestParam int id, Model model) {

        Product product = productService.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("imagename", product.getImages().get(1).getName());
        return "product";
    }
    
}
