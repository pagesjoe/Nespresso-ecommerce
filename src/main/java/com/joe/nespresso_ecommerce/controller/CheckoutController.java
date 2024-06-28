package com.joe.nespresso_ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.joe.nespresso_ecommerce.service.CheckoutService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CheckoutController {

    @Autowired
    CheckoutService checkoutService;
    
    @PostMapping("checkout")
    public String Postcheckout(HttpSession session) {

        //If user is not logged in
        if(session.getAttribute("user") == null){
            return "login_form";
        }else{
            checkoutService.checkout(session); 
            return "redirect:checkout";       
        }
    }

    @GetMapping("checkout")
    public String getcheckout() {
        return "checkout";
    }
}
