package com.joe.nespresso_ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joe.nespresso_ecommerce.entity.Authority;
import com.joe.nespresso_ecommerce.entity.AuthorityId;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, AuthorityId>{

}
