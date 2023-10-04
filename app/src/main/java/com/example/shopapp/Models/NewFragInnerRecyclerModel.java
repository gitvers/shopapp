package com.example.shopapp.Models;

public class NewFragInnerRecyclerModel {
    private String description;
    private String price;
    private int images;

    public NewFragInnerRecyclerModel(String description, String price, int images) {
        this.description = description;
        this.price = price;
        this.images = images;
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

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
