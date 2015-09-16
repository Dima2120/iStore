package com.store.service;

import com.store.model.Cart;
import com.store.model.Product;

import java.util.List;

public class CartServiceImpl implements CartService {
    private Cart cart;

    public CartServiceImpl() {
        this.cart = new Cart();
        System.out.println("Cart is created");
    }


    public void addProduct(Integer productId) {

    }

    public void addProduct(Product product) {
        cart.getProducts().add(product);

    }

    public void removeProduct(Integer product) {

    }

    public boolean payCart(Integer cartId) {
        return false;
    }

    public void removeProduct(Product product) {
        cart.getProducts().remove(product);

    }
    public List<Product> findAll() {
        return cart.getProducts();


    }

}
