package com.joe.nespresso_ecommerce.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class AuthorityId implements Serializable{

    private String authority;

    private String username;



    
    public AuthorityId() {
    }

    public AuthorityId(String authority, String username) {
        this.authority = authority;
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
}
