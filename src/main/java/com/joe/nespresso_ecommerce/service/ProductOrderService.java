package com.joe.nespresso_ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joe.nespresso_ecommerce.entity.ProductOrder;
import com.joe.nespresso_ecommerce.repository.ProductOrderRepository;

@Service
public class ProductOrderService {

    @Autowired
    ProductOrderRepository productOrderRepository;

    public void save(ProductOrder productOrder) {
        productOrderRepository.save(productOrder);
    }

    public List<ProductOrder> getByOrderId(int orderId){
        return productOrderRepository.findByIdOrderId(orderId);
    };


}
