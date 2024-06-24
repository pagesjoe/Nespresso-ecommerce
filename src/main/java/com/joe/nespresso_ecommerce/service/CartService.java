package com.joe.nespresso_ecommerce.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joe.nespresso_ecommerce.entity.Product;

import jakarta.servlet.http.HttpSession;

@Service
public class CartService {

    @Autowired
    ProductService productService;

    //Add product to the cart
    public int addToCart(int qty, int productId, HttpSession session){

        // Incrementing the session's cart qty
        int newCartQty = ((Integer)session.getAttribute("qty")) + qty;
        session.setAttribute("qty", newCartQty);

        //Getting the added product by id
        Product product = productService.findById(productId);

        //If session "cart" attribute is not set, create "cart" and add the product to it
        if(session.getAttribute("cart") == null){
            //create "cart" and add the product to it
            HashMap<Product, Integer> cart = new HashMap<>();
            cart.put(product, qty);

            //Add the cart to the session
            session.setAttribute("cart", cart);
        }else{

            //Get the session cart attribute
            HashMap<Product, Integer> cart = (HashMap<Product, Integer>) session.getAttribute("cart");

            //If the added product is not in the cart
            if(!productIsInCart(productId, cart)){
                //Put the product in the cart
                cart.put(product, qty);
            }else{
                //else, update the product qty in the cart
                int newProductQty = cart.get(product) + qty; 
                cart.put(product, newProductQty);
            }

            //Update the session cart attribute
            session.setAttribute("cart", cart);

        }

        
        //Update the session total attribute
        float subTotal = product.getPrice() * qty;
        //If total attribute is created
        if(session.getAttribute("total") != null){
            System.out.println("set" + subTotal);
            float newTotal = ((float)session.getAttribute("total") + subTotal);
            session.setAttribute("total", newTotal);
        }else{
            //If not, create the total attribute
            System.out.println("not set" + subTotal);
            session.setAttribute("total", subTotal);
        }

        return newCartQty;
    }


    //If the added product is in the cart
    public boolean productIsInCart(int productId, HashMap<Product, Integer> cart){
        for(Product theProduct: cart.keySet()){
            if(theProduct.getId() == productId){
                return true;
            }
        }
        return false;
    }


    public void remove(int id, HttpSession session) {
        //Get the cart
        HashMap<Product, Integer> cart = (HashMap<Product, Integer>) session.getAttribute("cart");

        //Get the product
        Product product = productService.findById(id);

        //Get the product quantity in the cart
        int productQty = cart.get(product);

        //Remove the product entry from the cart
        cart.remove(product);

        //Decrement the cart qty
        int newQty = (Integer)session.getAttribute("qty") - productQty;
        session.setAttribute("qty", newQty);

        //Update the total
        float subTotal = productQty * product.getPrice();
        float newTotal = (float)session.getAttribute("total") - subTotal;
        session.setAttribute("total", newTotal);
    }


    public void update(int id, int newProductQty, HttpSession session) {
        //Get the cart
        HashMap<Product, Integer> cart = (HashMap<Product, Integer>) session.getAttribute("cart");

        //Get the product
        Product product = productService.findById(id);

        //Get the product quantity in the cart
        int oldProductQty = cart.get(product);

        //update the product qty in the cart
        cart.put(product, newProductQty);

        //Increment the cart qty
        int newCartQty = (Integer)session.getAttribute("qty") + (newProductQty - oldProductQty);
        session.setAttribute("qty", newCartQty);

        //Update the total
        float oldSubTotal = oldProductQty * product.getPrice();
        float newSubTotal = newProductQty * product.getPrice();
        float newTotal = (float)session.getAttribute("total") + newSubTotal - oldSubTotal;
        session.setAttribute("total", newTotal);
    }
    
}
