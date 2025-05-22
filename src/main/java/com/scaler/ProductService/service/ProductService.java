package com.scaler.ProductService.service;

import com.scaler.ProductService.exception.ProductNotFoundException;
import com.scaler.ProductService.model.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long id) throws ProductNotFoundException;

    List<Product> getAllProduct();

    Product createProduct(Product product);

    boolean deleteProduct(Long id);
}
