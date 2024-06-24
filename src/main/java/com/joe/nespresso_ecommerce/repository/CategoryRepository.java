package com.joe.nespresso_ecommerce.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joe.nespresso_ecommerce.entity.Category;
import com.joe.nespresso_ecommerce.entity.Product;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
