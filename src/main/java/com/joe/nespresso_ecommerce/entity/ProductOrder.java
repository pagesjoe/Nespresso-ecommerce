package com.joe.nespresso_ecommerce.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_order")
public class ProductOrder {

    @EmbeddedId
    private ProductOrderId id;

    // @ManyToOne
    // @MapsId
    // @JoinColumn(name = "product_id")
    // private Product product;

    // @ManyToOne
    // @MapsId
    // @JoinColumn(name = "order_id")
    // private Order order;

    private int quantity;



    public ProductOrder() {
    }

    
    
    public ProductOrder(ProductOrderId id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }



    // public ProductOrder(Product product, int quantity) {
    //     this.product = product;
    //     this.quantity = quantity;
    // }


    // public ProductOrder(Product product, Order order, int quantity) {
    //     this.product = product;
    //     this.order = order;
    //     this.quantity = quantity;
    // }


    public ProductOrderId getId() {
        return id;
    }

    public void setId(ProductOrderId id) {
        this.id = id;
    }

    // public Product getProduct() {
    //     return product;
    // }

    // public void setProduct(Product product) {
    //     this.product = product;
    // }

    // public Order getOrder() {
    //     return order;
    // }

    // public void setOrder(Order order) {
    //     this.order = order;
    // }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
}
