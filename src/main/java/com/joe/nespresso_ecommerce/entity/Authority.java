package com.joe.nespresso_ecommerce.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authority {

    @EmbeddedId
    AuthorityId authorityId;



    public Authority() {
    }

    public AuthorityId getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(AuthorityId authorityId) {
        this.authorityId = authorityId;
    }

    
}
