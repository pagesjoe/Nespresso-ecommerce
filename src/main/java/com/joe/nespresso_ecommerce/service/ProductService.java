package com.joe.nespresso_ecommerce.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.joe.nespresso_ecommerce.entity.Category;
import com.joe.nespresso_ecommerce.entity.Product;
import com.joe.nespresso_ecommerce.repository.CategoryRepository;
import com.joe.nespresso_ecommerce.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;



    public HashMap<Product, String> getShowmoreProducts(int categoryId){

        //Getting category object
        Category category = categoryRepository.findById(categoryId).get();

        //Finding products by category
        List<Product> products = productRepository.findByCategory(category);

        //Creating return hashmap
        HashMap<Product, String> productimageHash = new HashMap<>();

        //Getting imagename for every product
        for(Product product : products){
            
            String imagename = product.getImages().get(0).getName();

            productimageHash.put(product, imagename);
        }

        return productimageHash;
    }



    //Setting the homepage products hashmap
    public HashMap<String, HashMap<Product, String>> setHomePageProducts() {
        
        //Creating the products Hashmap<categoryname -> Hashmap<product->imagename> > 
        HashMap<String, HashMap<Product, String>> products = new HashMap<>();

        //looping for 3 categories
        for(int i = 1; i <=3 ; i++){
            //Getting the category first 8 products
            List<Product> categoryProductsList = this.getfirst8ProductsByCategoryId(i);

            //Creating hashmap between the product and corresponding image name
            HashMap<Product, String> productImageHash = new HashMap<>();

            //Looping on the products list and
            //Setting image name for every product
            for(Product product : categoryProductsList){
                //Getting image name of the product thumbnail image
                String imageName = product.getImages().get(0).getName();
                productImageHash.put(product, imageName);
            }

            //Putting the productImageHash in the products Hashmap
            String categoryName = categoryRepository.findById(i).get().getName();
            products.put(categoryName, productImageHash);
        }

        return products;
        
    }



    //Get first 8 products from a category
    public List<Product> getfirst8ProductsByCategoryId(int categoryId) {
        //create pageable of 8 elements only
        Pageable pageable = PageRequest.of(0, 8);

        //Find category 
        Category category = categoryRepository.findById(categoryId).get();

        //Find first 8 products with specific category
        return productRepository.findByCategory(category, pageable);
    }



    public Product findById(int productId) {

        return productRepository.findById(productId).get();
    }

}
