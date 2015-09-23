package com.store;


import com.store.model.Category;
import com.store.model.Customer;
import com.store.model.Product;
import com.store.service.CartServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Store {
    public static void main(String[] args) {
        Store store = new Store();
        Customer customer = new Customer();
        customer.setCash(1000);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to iStore");
        while (true) {
            System.out.println("- list of products press [1] ");
            System.out.println("- exit press [2]");
            Integer scr = scanner.nextInt();
            if (scr == 1) {
                store.shoppingDialog(customer);
            }
            if (scr == 2) {
                break;
            }
        }


    }

    private void shoppingDialog(Customer customer) {
        HashMap<Integer, Product> listProducts = initStore();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of product to add it to the cart");
        CartServiceImpl cartService = new CartServiceImpl();
        customer.setCarts(cartService.getCart());

        for (java.util.Map.Entry<Integer, Product> entry : listProducts.entrySet()) {
            Product product = entry.getValue();
            System.out.println("Product #" + product.getProductId() + " | " + product.getTitle() + " | " + product.getPrice() + "$");
        }
        while (true) {

            System.out.println("- see the cart enter [show]");
            System.out.println("- to delete the product press [del {id}]");
            System.out.println("- to cancel shopping cart press [cancel]");
            System.out.println("- to pay the cart press [pay]");
            String scr = scanner.nextLine();
            if (scr.contains("del")) {
                Integer id = Integer.parseInt(scr.split(" ")[1]);
                Product delProduct = listProducts.get(id);
                cartService.removeProduct(delProduct);
            } else if (scr.equals("show")) {
                System.out.println("You cart :");
                System.out.println("You cash :" + customer.getCash());
                for (Product prod : cartService.findAll()) {
                    System.out.println("Product #" + prod.getProductId() + " | " + prod.getTitle() + " | " + " Quantity: [" + prod.getQuantity() + "] | " + prod.getPrice() + "$");
                }
                System.out.println("Sum of products :" + cartService.subTotal());
                System.out.println();

            } else if (scr.equals("cancel")) {
                break;
            } else if (scr.equals("pay")) {
                int toPay = cartService.subTotal();
                int cash = customer.getCash();
                if (cash > toPay) {
                    customer.setCash(cash - toPay);
                    customer.getCarts().setIsPayed(true);
                    System.out.println("You cart is payed. Thank you !");
                    System.out.println("You cash :" + customer.getCash());
                    break;
                } else System.out.println("You have not enought money! ");
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
