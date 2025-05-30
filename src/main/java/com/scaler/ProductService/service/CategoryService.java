package com.scaler.ProductService.service;

import com.scaler.ProductService.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public void deleteCatergoryById(Long id){
        categoryRepository.deleteById(id);
    }
}
