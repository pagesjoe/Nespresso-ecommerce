package com.joe.nespresso_ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joe.nespresso_ecommerce.entity.Authority;
import com.joe.nespresso_ecommerce.entity.AuthorityId;
import com.joe.nespresso_ecommerce.repository.AuthorityRepository;

@Service
public class AuthorityService {

    @Autowired
    AuthorityRepository authorityRepository;

    public void setAuthority(String role, String username) {
       
        Authority authority = new Authority();
        authority.setAuthorityId(new AuthorityId(role, username));
        authorityRepository.save(authority);
    }
}
