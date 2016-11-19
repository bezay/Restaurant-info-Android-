package com.example.bezay.easyeat.model;

import java.sql.Blob;

/**
 * Created by BeZaY on 11/11/2016.
 */
public class Product {
    private String image;
    private String name;
    private String address;

    public Product(String image, String name, String address) {
        this.image = image;
        this.name = name;
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

