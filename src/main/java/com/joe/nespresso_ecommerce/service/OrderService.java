package com.joe.nespresso_ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joe.nespresso_ecommerce.entity.Order;
import com.joe.nespresso_ecommerce.entity.User;
import com.joe.nespresso_ecommerce.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public void save(Order order){
        orderRepository.save(order);
    }

    public List<Order> findByUser(User user){
        return orderRepository.findByUser(user);
    }
}
