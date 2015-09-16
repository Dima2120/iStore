package com.store;


import com.store.model.Category;
import com.store.model.Product;
import com.store.service.CartServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Store {
    public static void main(String[] args) {
        Store store = new Store();


        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to iStore");
        while (true) {
            System.out.println("- list of products press [1] ");
            System.out.println("- exit press [2]");
            Integer scr = scanner.nextInt();
            if (scr == 1) {
                store.shoppingDialog();
            }
            if (scr == 2) {
                break;
            }
        }


    }

    private void shoppingDialog() {
        HashMap<Integer, Product> listProducts = initStore();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of product to add it to the cart");
        CartServiceImpl cartService = new CartServiceImpl();

        while (true) {
            for (java.util.Map.Entry<Integer, Product> entry : listProducts.entrySet()) {
                Product product = entry.getValue();
                System.out.println("Product #" + product.getProductId() + " | " + product.getTitle() + " | " + product.getPrice() + "$");
                System.out.println("- see the cart enter [0]");
                Integer scr = scanner.nextInt();
                if (scr == 0) {
                    System.out.println("You cart :");
                    for (Product prod : cartService.findAll()) {
                        System.out.println("Product #" + product.getProductId() + " | " + product.getTitle() + " | " + product.getPrice() + "$");
                    }
                    System.out.println();
                    break;
                } else {
                    cartService.addProduct(listProducts.get(scr));
                }


            }
        }

    }

    private static HashMap<Integer, Product> initStore() {
        Category category = new Category();
        category.setTitle("Fruits");
        Product product = new Product();
        product.setTitle("Apple");
        product.setCategory(category);
        product.setQuantity(1);
        product.setProductId(1);
        product.setPrice(100);

        HashMap<Integer, Product> listProducts = new HashMap<Integer, Product>();
        listProducts.put(product.getProductId(), product);

        return listProducts;
    }

    ;
}
