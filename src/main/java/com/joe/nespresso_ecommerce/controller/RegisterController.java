package com.joe.nespresso_ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joe.nespresso_ecommerce.entity.User;
import com.joe.nespresso_ecommerce.service.AuthorityService;
import com.joe.nespresso_ecommerce.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @Autowired
    AuthorityService authorityService;

    @GetMapping("/register")
    public String getRegisterForm(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        return "register_form";
    }

    @PostMapping("/register")
    public String postRegister(@Valid User user, BindingResult result, Model model, @RequestParam String role) {
        
        //If validation errors found
        if(result.hasErrors()){
            return "register_form";
        }

        //If username already exists
        if(userService.existsByUsername(user.getUsername())){
            Boolean usernameExists = true;
            model.addAttribute("usernameExists", usernameExists);
            return "register_form";
        }

        //If email already exists
        if(userService.existsByEmail(user.getEmail())){
            Boolean emailExists = true;
            model.addAttribute("emailExists", emailExists);
            return "register_form";
        }

        //Encrypt the password
        userService.encryptPassword(user);

        //Set enabled to 1
        user.setEnabled(true);

        //Set the authority
        authorityService.setAuthority(role,user.getUsername());

        //Save the user
        userService.save(user);

        return "redirect:loginpage";
    }
    
    
}
