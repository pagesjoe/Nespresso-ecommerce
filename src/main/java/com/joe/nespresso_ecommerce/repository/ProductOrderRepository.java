package com.joe.nespresso_ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joe.nespresso_ecommerce.entity.ProductOrder;
import com.joe.nespresso_ecommerce.entity.ProductOrderId;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, ProductOrderId>{

    public List<ProductOrder> findByIdOrderId(int orderId);
}
