package com.store;

public class Enter {
    int password = 0;

    public void enter() {
        System.out.println("Welcome to iStore, please enter you login and password...");
    }

    void authorization(int i) {
        //this.password = i;
        if (i == 1) {
            System.out.println("Authorization successful, Please select product category.");
        } else {
            System.out.println("Unfortunately you enter the wrong password, Try again .");
        }
    }

    void choseProduct(int i) {
        if (i == 1) {
            System.out.println("You have chosen a product number 1");
        } else if (i == 2) {
            System.out.println("You have chosen a product number 2");
        } else if (i == 3) {
            System.out.println("You have chosen a product number 3");
        } else if (i == 4) {
            System.out.println("You have chosen a product number 4");
        }
    }
}

class Test {

    public static void main(String[] args) {
        Enter store = new Enter();
        store.enter();
        store.authorization(1);
        store.choseProduct(2);
    }
}

