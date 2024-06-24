package com.joe.nespresso_ecommerce.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joe.nespresso_ecommerce.entity.Order;
import com.joe.nespresso_ecommerce.entity.Product;
import com.joe.nespresso_ecommerce.entity.ProductOrder;
import com.joe.nespresso_ecommerce.entity.User;

import jakarta.servlet.http.HttpSession;

@Service
public class PreviousOrdersService {

    @Autowired
    OrderService orderService;

    @Autowired
    ProductOrderService productOderService;

    @Autowired
    ProductService productService;

    public HashMap<Order, HashMap<Product, List<String>>> getPreviousOrders(HttpSession session){

        //Creating return hashmap
        HashMap<Order, HashMap<Product, List<String>>> previousOrders = new HashMap<>();

        //Getting user
        User user = (User)session.getAttribute("user");

        //Getting all orders by user
        List<Order> orders = orderService.findByUser(user);

        //getting products per orderid
        for(Order order : orders){

            List<ProductOrder> productOrders = productOderService.getByOrderId(order.getId());

            //Creating every order list of products
            HashMap<Product, List<String>> products = new HashMap<>();

            //adding products and their image, quantity to the order corresponding hashmap
            for(ProductOrder theProductOrder : productOrders){
                //Getting the product id
                int productId = theProductOrder.getId().getProductId();

                //Getting the product by id
                Product product = productService.findById(productId);

                // Getting product imagename
                String imagename = product.getImages().get(0).getName();

                //Getting product quantity
                String productQty = Integer.toString(theProductOrder.getQuantity()); 

                //Adding imagename and quantity to a list together
                List<String> productDetails = new ArrayList<>();
                productDetails.add(imagename);
                productDetails.add(productQty);

                //Putting <product, List(imagename,qty)>
                products.put(product, productDetails);
            }

            //Putting an order and its corresponding products hashmap
            previousOrders.put(order, products);
        }

        return previousOrders;
    }

    
}
