package com.scaler.ProductService.service;

import com.scaler.ProductService.exception.CategoryNotFoundException;
import com.scaler.ProductService.exception.ProductNotFoundException;
import com.scaler.ProductService.model.Category;
import com.scaler.ProductService.model.Product;
import com.scaler.ProductService.repositories.CategoryRepository;
import com.scaler.ProductService.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SelfStoreProductService")
public class SelfStoreProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfStoreProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return productRepository.findById(id).orElseThrow(()->new ProductNotFoundException(id,"Product Id is not valid"));
//        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) throws Exception {

        Category category = product.getCategory();

        if(category == null){
            throw new CategoryNotFoundException("Product must contain category to save in the DB");
        }

        Optional<Category> category1 = categoryRepository.findByTitle(category.getTitle());

        if(category1.isEmpty()){
            Category newCategory = categoryRepository.save(category);
            category.setId(newCategory.getId());
        }
            product.setCategory(category1.get());
        if(null != product){
            productRepository.save(product);
        }
        return product;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }
}
