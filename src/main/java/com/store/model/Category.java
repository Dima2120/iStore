package com.store.model;


public class Category {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Category{" +
                "title='" + title + '\'' +
                '}';
    }
}