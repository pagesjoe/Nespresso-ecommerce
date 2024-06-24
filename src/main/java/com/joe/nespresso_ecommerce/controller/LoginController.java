package com.joe.nespresso_ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    @GetMapping("/loginpage")
    public String getLoginForm() {
        return "login_form";
    }

    
    
}
