package com.joe.nespresso_ecommerce.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joe.nespresso_ecommerce.entity.Product;
import com.joe.nespresso_ecommerce.service.CartService;
import com.joe.nespresso_ecommerce.service.ProductService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @Autowired
    CartService cartService;

    @GetMapping("")
    public String getHome(Model model, HttpSession session) {

        //setting session cart qty
        if(session.getAttribute("qty") == null){
            session.setAttribute("qty", 0);
        } 

        model.addAttribute("session", session);

        //Adding homepage products
        model.addAttribute("products", productService.setHomePageProducts());

        return "index";
    }





    
    
    
}
