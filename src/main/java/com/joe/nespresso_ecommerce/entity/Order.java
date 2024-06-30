package com.joe.nespresso_ecommerce.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private java.sql.Date date;

    private double price;

    @Column(name = "no_items")
    private int numOfItems;

    @ManyToMany(mappedBy = "orders")
    List<Product> products;

    @ManyToOne
    @JoinColumn(name = "user_username")
    private User user;

    // @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    // private List<ProductOrder> productOrders;

    
    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumOfItems() {
        return numOfItems;
    }

    public void setNumOfItems(int numOfItems) {
        this.numOfItems = numOfItems;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // public List<ProductOrder> getProductOrders() {
    //     return productOrders;
    // }

    // public void setProductOrders(List<ProductOrder> productOrders) {
    //     this.productOrders = productOrders;
    // }

    
}
