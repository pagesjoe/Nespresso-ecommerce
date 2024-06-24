package com.joe.nespresso_ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joe.nespresso_ecommerce.entity.Order;
import com.joe.nespresso_ecommerce.entity.User;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order, Integer>{

    public List<Order> findByUser(User user);
}
