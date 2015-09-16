package com.store.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products = new ArrayList<Product>();
    private Integer totalPrice;
    private Boolean isPayed;
    private Integer cartId;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(Boolean isPayed) {
        this.isPayed = isPayed;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + products +
                ", totalPrice=" + totalPrice +
                ", isPayed=" + isPayed +
                '}';
    }
}




