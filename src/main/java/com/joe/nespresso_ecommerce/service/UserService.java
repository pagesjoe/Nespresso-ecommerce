package com.joe.nespresso_ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.joe.nespresso_ecommerce.entity.Authority;
import com.joe.nespresso_ecommerce.entity.AuthorityId;
import com.joe.nespresso_ecommerce.entity.User;
import com.joe.nespresso_ecommerce.repository.AuthorityRepository;
import com.joe.nespresso_ecommerce.repository.UserRepository;

import jakarta.validation.Valid;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public Boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
        
    }

    public Boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public void encryptPassword(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

    }

    public void save(User user) {
        userRepository.save(user);
    }

    
    
}
