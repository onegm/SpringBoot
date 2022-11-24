package com.libraryApplication.library.controller;

import com.libraryApplication.library.entity.Category;
import com.libraryApplication.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/categories/{id}")
    public Category getCategory(@PathVariable Long id){
        return categoryService.getCategory(id);
    }

    @PostMapping("/categories/new")
    public void createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
    }

    @PutMapping("/categories/update")
    public void updateCategory(@RequestBody Category category){
        categoryService.updateCategory(category);
    }

    @DeleteMapping("/categories/remove/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.removeCategory(id);
    }
}
