package com.joe.nespresso_ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joe.nespresso_ecommerce.service.CartService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class CartController {

    @Autowired
    CartService cartService;



    @GetMapping("/cart")
    public String getCart(Model model, HttpSession session) {
        model.addAttribute("session", session);
        return "cart";
    }




    //Updating the cart when pressing the add button
    @PostMapping("/productadd")
    public ResponseEntity<String> productAdd(@RequestParam int qty, @RequestParam int id, HttpSession session,
        Model model) {

        // Add the product to the cart
        int newQty = cartService.addToCart(qty, id, session);

        //Return response with new cart quantity
        String response = Integer.toString(newQty);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }




    //Update the badge number when pressing the add button
    @PostMapping("/updateBadge")
    public ResponseEntity<String> postMethodName(@RequestParam int id, HttpSession session) {
        int badgeNumber = cartService.getProductQuantity(id, session);

        return new ResponseEntity<String>(Integer.toString(badgeNumber), HttpStatus.OK);
    }
    




    //Update the cart when deleting a product or updating the quantity of a product from the cart page
    @PostMapping("cartupdate")
    public String updateCart(@RequestParam String action, @RequestParam int qty, @RequestParam int id,
        HttpSession session) {
        
        if(action.equals("remove")){
            cartService.remove(id, session);
        }else{
            cartService.update(id, qty, session);
        }
        return "cart_update";
    }
    
    
   
    
}
