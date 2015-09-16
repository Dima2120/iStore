package com.store.service;


import com.store.model.Product;

public interface CartService {
    void addProduct(Integer productId);
    void addProduct(Product product);
    void removeProduct(Integer productId);
    boolean payCart(Integer cartId);


}
