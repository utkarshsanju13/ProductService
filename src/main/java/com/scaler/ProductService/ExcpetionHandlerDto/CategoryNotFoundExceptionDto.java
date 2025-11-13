package com.scaler.ProductService.ExcpetionHandlerDto;

public class CategoryNotFoundExceptionDto {

    private String message;

    public CategoryNotFoundExceptionDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
