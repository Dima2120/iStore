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

        for (java.util.Map.Entry<Integer, Product> entry : listProducts.entrySet()) {
            Product product = entry.getValue();
            System.out.println("Product #" + product.getProductId() + " | " + product.getTitle() + " | " + product.getPrice() + "$");
        }
        while (true) {
            System.out.println("- see the cart enter [show]");
            System.out.println("- to delete the product press [del {id}]");
            String scr = scanner.nextLine();
            if (scr.contains("del")) {
                Integer id = Integer.parseInt(scr.split(" ")[1]);
                Product delProduct = listProducts.get(id);
                cartService.removeProduct(delProduct);
            } else if (scr.equals("show")) {
                System.out.println("You cart :");
                for (Product prod : cartService.findAll()) {
                    System.out.println("Product #" + prod.getProductId() + " | " + prod.getTitle() + " | " + " Quantity: [" + prod.getQuantity() + "] | " + prod.getPrice() + "$");
                }
                System.out.println("Sum of products :" + cartService.subTotal());
                System.out.println();
                break;
            } else {
                cartService.addProduct(listProducts.get(Integer.parseInt(scr)));
            }
            System.out.println();
        }


    }

    private static HashMap<Integer, Product> initStore() {
        Category category = new Category();
        HashMap<Integer, Product> listProducts = new HashMap<Integer, Product>();
        category.setTitle("Fruits");
        for (int i = 1; i < 11; i++) {
            Product product = new Product();
            product.setTitle("Apple# " + i);
            product.setCategory(category);
            product.setQuantity(1);
            product.setProductId(i);
            product.setPrice(100);

            listProducts.put(product.getProductId(), product);
        }
        return listProducts;
    }

    ;
}
