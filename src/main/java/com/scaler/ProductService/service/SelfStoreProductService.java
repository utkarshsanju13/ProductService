package com.scaler.ProductService.service;

import com.scaler.ProductService.exception.ProductNotFoundException;
import com.scaler.ProductService.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfStoreProductService")
public class SelfStoreProductService implements ProductService{
    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long id) {
        return false;
    }
}
