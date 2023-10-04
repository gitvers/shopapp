package com.example.shopapp.Models;

public class Category1Model {
    private int images;
    private String name;
    private String description;
    private String price;

    public Category1Model(int images, String name, String description, String price) {
        this.images = images;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
