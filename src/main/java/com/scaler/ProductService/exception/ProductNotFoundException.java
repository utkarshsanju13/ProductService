package com.scaler.ProductService.exception;

public class ProductNotFoundException extends Exception{

    private Long id;
//    private String message; //no need for this..

    public ProductNotFoundException(Long id, String message){
        super(message);
        this.id = id;
    }

    public ProductNotFoundException(String message){
        super(message);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
