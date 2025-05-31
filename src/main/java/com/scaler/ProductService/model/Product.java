package com.scaler.ProductService.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product extends BaseModel{

    private String title;
    private String description;
    private Double price;
    private String image;
    @ManyToOne (fetch = FetchType.LAZY)
    @JsonManagedReference
//            (cascade = CascadeType.DETACH)
//            (cascade = CascadeType.REFRESH)
//            (cascade = CascadeType.MERGE)
    private Category category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
