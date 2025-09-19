package com.scaler.ProductService.exception;

public class CategoryNotFoundException extends Exception{

    private Long id;
    private String message;

    public CategoryNotFoundException(String message, Long id, String message1) {
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

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
