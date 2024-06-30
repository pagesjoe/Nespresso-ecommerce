package com.joe.nespresso_ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {

    @GetMapping("/loginpage")
    public String getLoginForm(HttpSession session) {
        //If user is already logged in
        if(session.getAttribute("user") != null){
            return "redirect:";
        }
        return "login_form";
    }

    
    
}
