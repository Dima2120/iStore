package com.store;

public class Buyer {
    private String name;
    private Short id;


    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = name;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "name='" + name + '\'' +
                ", is='" + id + '\'' +
                '}';
    }

}
