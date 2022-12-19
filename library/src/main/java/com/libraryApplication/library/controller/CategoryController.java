package com.libraryApplication.library.controller;

import com.libraryApplication.library.entity.Author;
import com.libraryApplication.library.entity.Book;
import com.libraryApplication.library.entity.Category;
import com.libraryApplication.library.service.CategoryService;
import org.hibernate.id.BulkInsertionCapableIdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public String getAllCategories(Model model){
        model.addAttribute("categoryList", categoryService.getAllCategories());
        return "category/categories";
    }

    @GetMapping("/categories/{id}")
    public String getCategory(@PathVariable Long id, Model model){
        Category category = categoryService.getCategory(id);
        Set<Book> books = category.getBooks();
//        String authors = "";
//        for(Book book : books){
//            for(Author author : book.getAuthors()){
//                authors += author.getName() + "; ";
//            }
//        }
        model.addAttribute("category", category);
        model.addAttribute("books", books);
        return "category/category-books";
    }

    @GetMapping("/categories/new")
    public String createCategory(Category category){
        return "category/new-category";
    }

    @PostMapping("/categories/save-category")
    public String saveCategory(Category category, BindingResult result){
        if(result.hasErrors()){
            return "category/new-category";
        }
        categoryService.createCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/update/{id}")
    public String updateCategory(@PathVariable Long id, Model model){
        model.addAttribute("category", categoryService.getCategory(id));
        return "category/edit-category";
    }

    @PostMapping("/categories/save-update/{id}")
    public String updateCategory(@PathVariable Long id, Category category, BindingResult result){
        if(result.hasErrors()){
            return "category/edit-category";
        }
        categoryService.updateCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/remove/{id}")
    public String deleteCategory(@PathVariable Long id){
        categoryService.removeCategory(id);
        return"redirect:/categories";
    }
}
