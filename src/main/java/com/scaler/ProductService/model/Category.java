package com.scaler.ProductService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name = "categories")
public class Category extends BaseModel {

    private  String title;

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    @JsonBackReference
//            , cascade = CascadeType.REMOVE)
    private List<Product> listOfProduct;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Product> getListOfProduct() {
        return listOfProduct;
    }

    public void setListOfProduct(List<Product> listOfProduct) {
        this.listOfProduct = listOfProduct;
    }
}
