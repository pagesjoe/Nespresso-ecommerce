package com.joe.nespresso_ecommerce.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProductOrderId implements Serializable{

    @Column(name = "product_id")
    private int productId;

    @Column(name = "order_id")
    private int orderId;


    
    public ProductOrderId() {
    }

    public ProductOrderId(int productId, int orderId) {
        this.productId = productId;
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    
}
