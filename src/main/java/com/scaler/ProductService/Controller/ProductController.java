package com.scaler.ProductService.Controller;

import com.scaler.ProductService.ExcpetionHandlerDto.RuntimeExceptionDto;
import com.scaler.ProductService.exception.ProductNotFoundException;
import com.scaler.ProductService.model.Product;
import com.scaler.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
//    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping ("/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId) throws ProductNotFoundException {

        ResponseEntity<Product>  responseEntity =
                new ResponseEntity<>(
                    productService.getSingleProduct(productId),
                        HttpStatus.OK
        );

        return responseEntity;
    }

    @GetMapping("/")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @PostMapping("/ ")
    public Product createProduct(@RequestBody Product product){

        return new Product();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id){
         return null;
    }

    @PatchMapping("/{id}")
    public Product update(@PathVariable("id") Long id){
        return new Product();
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id){
        return new Product();
    }


    //Controller specific exception...
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<RuntimeExceptionDto> handleRuntimeException(){

        RuntimeExceptionDto runtimeExceptionDto = new RuntimeExceptionDto();
        runtimeExceptionDto.setMessage("Exception from the controller....");
        runtimeExceptionDto.setResolution("Please try again..for more information CONTACT US..Thanks! ");
        return new ResponseEntity<RuntimeExceptionDto>(
                runtimeExceptionDto,
                HttpStatus.NOT_FOUND
        );
    }


}
