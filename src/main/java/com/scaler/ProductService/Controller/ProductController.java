package com.scaler.ProductService.Controller;

import com.scaler.ProductService.Common.AuthCommon;
import com.scaler.ProductService.ExcpetionHandlerDto.RuntimeExceptionDto;
import com.scaler.ProductService.Projection.ProductProjection;
import com.scaler.ProductService.exception.InvalidTokenException;
import com.scaler.ProductService.exception.ProductNotFoundException;
import com.scaler.ProductService.model.Category;
import com.scaler.ProductService.model.Product;
import com.scaler.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    /* Use pf @Qualifier annotation
    * Note: point the spring register the bean name as the class name
    * But the name of the bean starts with lower case
    * fakeStoreProductServiceImpl instead of FakeStoreProductServiceImpl*/
    public ProductController(@Qualifier("selfStoreProductService") ProductService productService){
        this.productService = productService;
    }

    /*This is working as we marked the SelfProductService as @Primary bean*/
//    public ProductController(ProductService productService){
//        this.productService = productService;
//    }

    @GetMapping ("/{productId}/{token}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId, @PathVariable String token) throws ProductNotFoundException, InvalidTokenException {

        //Authentication
        boolean authvalidation = AuthCommon.authTokenValidation(token);

         Product product = productService.getSingleProduct(productId); // A this point only select * from product query execute
        Category category = product.getCategory();
        System.out.println(category.getTitle());
        ResponseEntity<Product>  responseEntity =
                new ResponseEntity<>(
                    product,
                        HttpStatus.OK
        );

        return responseEntity;
    }

    @GetMapping("/productProjection/{title}")
    public ResponseEntity<ProductProjection> getProductByTitle(@PathVariable String title){

        ProductProjection productProjection = productService.findProductByTitle(title);
        return ResponseEntity.ok(productProjection);
    }

    @GetMapping("/")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) throws  Exception{
        Product product1 = productService.createProduct(product);
        return product1;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);

         return new ResponseEntity<>(HttpStatus.OK);
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
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<RuntimeExceptionDto> handleRuntimeException(){
//
//        RuntimeExceptionDto runtimeExceptionDto = new RuntimeExceptionDto();
//        runtimeExceptionDto.setMessage("Exception from the controller....");
//        runtimeExceptionDto.setResolution("Please try again..for more information CONTACT US..Thanks! ");
//        return new ResponseEntity<RuntimeExceptionDto>(
//                runtimeExceptionDto,
//                HttpStatus.NOT_FOUND
//        );
//    }


}
