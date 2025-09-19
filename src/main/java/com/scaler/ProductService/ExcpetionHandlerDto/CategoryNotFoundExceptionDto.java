package com.scaler.ProductService.ExcpetionHandlerDto;

public class CategoryNotFoundExceptionDto {

    private String message;
    private String HttpStatus;

    public CategoryNotFoundExceptionDto(String httpStatus, String message) {
        HttpStatus = httpStatus;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHttpStatus() {
        return HttpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        HttpStatus = httpStatus;
    }
}
