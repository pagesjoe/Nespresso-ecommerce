package com.joe.nespresso_ecommerce.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Product {

    @Id
    private int id;

    private String name;

    private String details;

    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    List<Image> images;

    @ManyToMany
    @JoinTable(name = "product_order",
        joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"))
    private List<Order> orders;

    // @OneToMany(mappedBy = "product")
    // List<ProductOrder> productOrders;


    
    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    
    // public List<ProductOrder> getProductOrders() {
    //     return productOrders;
    // }

    // public void setProductOrders(List<ProductOrder> productOrders) {
    //     this.productOrders = productOrders;
    // }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product other = (Product) obj;
        return other.id == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
    

}
