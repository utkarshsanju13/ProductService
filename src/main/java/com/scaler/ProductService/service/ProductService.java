package com.scaler.ProductService.service;

import com.scaler.ProductService.exception.ProductNotFoundException;
import com.scaler.ProductService.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product getSingleProduct(Long id) throws ProductNotFoundException;

    List<Product> getAllProduct();

    Product createProduct(Product product) throws Exception;

    void deleteProduct(Long id);
}
