package com.scaler.ProductService.exception;

public class CategoryNotFoundException extends Exception{

    private Long id;
//    private String message; // No need ...this got inherited from the throwable class

    public CategoryNotFoundException(String message, Long id) {
        super(message);
        this.id = id;
    }

    public  CategoryNotFoundException(String message){
        super(message);
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
