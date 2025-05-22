package com.scaler.ProductService.ExcpetionHandlerDto;

public class RuntimeExceptionDto {

    private Long productId;
    private String message;
    private String resolution;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
}
