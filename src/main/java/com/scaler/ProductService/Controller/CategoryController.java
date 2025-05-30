package com.scaler.ProductService.Controller;

import com.scaler.ProductService.service.CategoryService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryByID(@PathVariable Long id){
        categoryService.deleteCatergoryById(id);
    }


}
