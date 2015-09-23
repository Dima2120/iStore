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
        for (Product prod : cart.getProducts()) {
            if (prod.equals(product)) {
                prod.setQuantity(prod.getQuantity() + 1);
                return;
            }
        }
        cart.getProducts().add(product);
    }

    public void removeProduct(Integer product) {


    }

    public boolean payCart(Integer cartId) {
        return false;
    }

    public void removeProduct(Product product) {
        for (Product prod : cart.getProducts()) {
            if (prod.equals(product)) {
                if (prod.getQuantity() > 1) {
                    prod.setQuantity(prod.getQuantity() - 1);
                } else {
                    cart.getProducts().remove(product);
                }
                return;
            }
        }
        System.out.println("Product not found id: " + product.getProductId());
    }

    public List<Product> findAll() {
        return cart.getProducts();


    }

    public Integer subTotal() {
        Integer totalPrice = 0;
        for (Product product : cart.getProducts()) {
            totalPrice += product.getPrice() * product.getQuantity();
        }
        return totalPrice;
    }
    public Cart getCart() {
        return cart;
    }

}
