package com.joe.nespresso_ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joe.nespresso_ecommerce.repository.CategoryRepository;
import com.joe.nespresso_ecommerce.service.ProductService;


@Controller
public class CategoryController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryRepository categoryRepository;


    @GetMapping("showmore")
    public String showmoreByCategory(@RequestParam int id, Model model) {
        
        model.addAttribute("category", categoryRepository.findById(id).get());
        model.addAttribute("products", productService.getShowmoreProducts(id));
        return "showmore";
    }
    
}
