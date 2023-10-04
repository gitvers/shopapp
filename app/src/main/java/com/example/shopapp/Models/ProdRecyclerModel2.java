package com.example.shopapp.Models;

public class ProdRecyclerModel2 {
    private int images;
    private String name;
    private String description;

    public ProdRecyclerModel2(int images, String name, String description) {
        this.images = images;
        this.name = name;
        this.description = description;
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
}
