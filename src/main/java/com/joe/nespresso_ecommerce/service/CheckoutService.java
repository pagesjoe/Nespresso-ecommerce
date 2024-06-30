package com.joe.nespresso_ecommerce.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joe.nespresso_ecommerce.entity.Order;
import com.joe.nespresso_ecommerce.entity.Product;
import com.joe.nespresso_ecommerce.entity.ProductOrder;
import com.joe.nespresso_ecommerce.entity.ProductOrderId;
import com.joe.nespresso_ecommerce.entity.User;

import jakarta.servlet.http.HttpSession;

@Service
public class CheckoutService {

    @Autowired
    OrderService orderService;

    @Autowired
    ProductOrderService productOderService;

    public void checkout(HttpSession session){

        //Create new order
        Order order = new Order();
        Date date = new Date();
        order.setDate(new java.sql.Date(date.getTime()));
        order.setNumOfItems((Integer)session.getAttribute("qty"));
        order.setPrice((double)session.getAttribute("total"));
        order.setUser((User) session.getAttribute("user"));

        //Save the order
        orderService.save(order);

        //Get the cart list of products
        HashMap<Product, Integer> cart = (HashMap<Product, Integer>) session.getAttribute("cart");

        //Creating productOrder objects for every product
        for(Product product : cart.keySet()){
            //Setting th id
            ProductOrderId productOrderId = new ProductOrderId(product.getId(), order.getId());
            //Setting the quantity
            ProductOrder productOrder = new ProductOrder(productOrderId, cart.get(product));

            //Saving the productOrder object
            productOderService.save(productOrder);
        }

        session.setAttribute("cart", null);
        session.setAttribute("qty", 0);
        double total = 0;
        session.setAttribute("total", total);

    }
}
