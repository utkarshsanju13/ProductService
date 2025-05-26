package com.scaler.ProductService.controllerAdvice;

import com.scaler.ProductService.ExcpetionHandlerDto.ProductNotFoundExceptionDto;
import com.scaler.ProductService.ExcpetionHandlerDto.RuntimeExceptionDto;
import com.scaler.ProductService.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceExceptionHandler {

//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<RuntimeExceptionDto> handleRuntimeException(){
//
//        RuntimeExceptionDto runtimeExceptionDto = new RuntimeExceptionDto();
//        runtimeExceptionDto.setMessage("Something went wrong..");
//        runtimeExceptionDto.setResolution("Please try again..for more information CONTACT US..Thanks! ");
//        return new ResponseEntity<RuntimeExceptionDto>(
//                        runtimeExceptionDto,
//                        HttpStatus.NOT_FOUND
//        );
//    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException ex){

        ProductNotFoundExceptionDto productNotFoundExceptionDto = new ProductNotFoundExceptionDto();
        productNotFoundExceptionDto.setId(ex.getId()); // TODO :
        productNotFoundExceptionDto.setMessage("Product is not found...");
        productNotFoundExceptionDto.setResolution("Please pass the correct product ID...");

        return new ResponseEntity<>(
                productNotFoundExceptionDto,
                HttpStatus.NOT_FOUND
        );
    }


}
