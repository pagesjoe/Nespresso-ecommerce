package com.joe.nespresso_ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.joe.nespresso_ecommerce.service.CheckoutService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CheckoutController {

    @Autowired
    CheckoutService checkoutService;
    
     @GetMapping("checkout")
    public String checkout(HttpSession session) {

        //If user is not logged in
        if(session.getAttribute("user") == null){
            return "login_form";
        }else{
            checkoutService.checkout(session); 
            return "checkout";       
        }
    }
}
