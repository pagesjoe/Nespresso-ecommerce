package com.joe.nespresso_ecommerce.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.joe.nespresso_ecommerce.entity.Category;
import com.joe.nespresso_ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

    public List<Product> findByCategory(Category category);

    public List<Product> findByCategory(Category category, Pageable pageable);
}
