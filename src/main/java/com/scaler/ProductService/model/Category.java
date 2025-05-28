package com.scaler.ProductService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name = "categories")
public class Category extends BaseModel {

    private  String title;

    @OneToMany(mappedBy = "category")
    private List<Product> listOfProduct;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
