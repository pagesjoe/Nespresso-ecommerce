package com.joe.nespresso_ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joe.nespresso_ecommerce.entity.Category;
import com.joe.nespresso_ecommerce.entity.Product;
import com.joe.nespresso_ecommerce.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

}
