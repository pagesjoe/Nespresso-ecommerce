package com.joe.nespresso_ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joe.nespresso_ecommerce.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

    boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    User findByUsername(String username);

}
