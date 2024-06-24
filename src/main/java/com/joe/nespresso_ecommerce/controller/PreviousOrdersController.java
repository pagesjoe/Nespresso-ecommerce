package com.joe.nespresso_ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joe.nespresso_ecommerce.service.PreviousOrdersService;

import jakarta.servlet.http.HttpSession;


@Controller
public class PreviousOrdersController {

    @Autowired
    PreviousOrdersService previousOrdersService;

    @GetMapping("/previousorders")
    public String getPreviousOrders(Model model, HttpSession session) {
        
        //Check if user is logged in
        if(session.getAttribute("user") == null){
            return "redirect:";
        }
    

        model.addAttribute("orders", previousOrdersService.getPreviousOrders(session));
        return "previous_orders";
    }
    
}
