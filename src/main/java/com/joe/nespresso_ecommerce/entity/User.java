package com.joe.nespresso_ecommerce.entity;

import java.util.List;

import com.joe.nespresso_ecommerce.validation.Email;
import com.joe.nespresso_ecommerce.validation.Name;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User {

    @Id
    @NotBlank(message = "username cannot be empty")
    private String username;

    private int id;

    @NotBlank(message = "first name cannot be empty")
    @Name(message = "First name cannot contain special characters")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "last name cannot be empty")
    @Name(message = "Last name cannot contain special characters")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "email cannot be empty")
    @Email(message = "Invalid Email")
    private String email;

    @NotBlank(message = "password cannot be empty")
    private String password;

    private boolean enabled;

    @OneToMany(mappedBy = "user")
    List<Order> orders;




    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    

}
