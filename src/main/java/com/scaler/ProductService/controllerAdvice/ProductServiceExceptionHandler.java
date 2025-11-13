package com.scaler.ProductService.controllerAdvice;

import com.scaler.ProductService.ExcpetionHandlerDto.CategoryNotFoundExceptionDto;
import com.scaler.ProductService.ExcpetionHandlerDto.ProductNotFoundExceptionDto;
import com.scaler.ProductService.ExcpetionHandlerDto.RuntimeExceptionDto;
import com.scaler.ProductService.dtos.exceptionDto.InvalidTokenExceptionDto;
import com.scaler.ProductService.exception.CategoryNotFoundException;
import com.scaler.ProductService.exception.InvalidTokenException;
import com.scaler.ProductService.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException ex){

        ProductNotFoundExceptionDto productNotFoundExceptionDto = new ProductNotFoundExceptionDto();
        productNotFoundExceptionDto.setId(ex.getId());
        productNotFoundExceptionDto.setMessage(ex.getMessage());
        productNotFoundExceptionDto.setResolution("Please pass the correct product ID...");

        return new ResponseEntity<>(
                productNotFoundExceptionDto,
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<CategoryNotFoundExceptionDto> handleCategoryNotFoundException(CategoryNotFoundException ex){

        CategoryNotFoundExceptionDto categoryNotFoundExceptionDto = new CategoryNotFoundExceptionDto(ex.getMessage());

        return new ResponseEntity<>(categoryNotFoundExceptionDto,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<InvalidTokenExceptionDto> handleUnauthorizeToken(InvalidTokenException ex){
        InvalidTokenExceptionDto invalidTokenExceptionDto = new InvalidTokenExceptionDto();
        invalidTokenExceptionDto.setMessage(ex.getMessage());

        return new ResponseEntity<>(invalidTokenExceptionDto,HttpStatus.UNAUTHORIZED);
    }


    /*@ExceptionHandler(RuntimeException.class)
    public ResponseEntity<RuntimeExceptionDto> handleRuntimeException(){

        RuntimeExceptionDto runtimeExceptionDto = new RuntimeExceptionDto();
        runtimeExceptionDto.setMessage("Something went wrong..");
        runtimeExceptionDto.setResolution("Please try again..for more information CONTACT US..Thanks! ");
        return new ResponseEntity<RuntimeExceptionDto>(
                        runtimeExceptionDto,
                        HttpStatus.NOT_FOUND
        );
    }*/


}
