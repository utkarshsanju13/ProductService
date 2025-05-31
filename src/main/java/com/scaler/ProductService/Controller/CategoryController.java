package com.scaler.ProductService.Controller;

import com.scaler.ProductService.model.Category;
import com.scaler.ProductService.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSingleCategory(@PathVariable Long id){
        return  new ResponseEntity<>(
                categoryService.getCategoryById(id),
                HttpStatus.OK
        );
//        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryByID(@PathVariable Long id){
        categoryService.deleteCatergoryById(id);
    }


}
