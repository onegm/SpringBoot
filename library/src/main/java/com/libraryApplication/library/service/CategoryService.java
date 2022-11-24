package com.libraryApplication.library.service;

import com.libraryApplication.library.entity.Category;
import com.libraryApplication.library.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public void createCategory(Category category){
        categoryRepository.save(category);
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategory(Long id){
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not Found"));
    }

    public void updateCategory(Category category){
        categoryRepository.save(category);
    }

    public void removeCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
