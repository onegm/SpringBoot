package com.libraryApplication.library.controller;

import com.libraryApplication.library.entity.Author;
import com.libraryApplication.library.entity.Book;
import com.libraryApplication.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/authors")
    public String getAllAuthors(Model model){
        model.addAttribute("authorList", authorService.getAllAuthors());
        return "author/authors";
    }

    @GetMapping("/authors/{id}")
    public String viewAuthor(@PathVariable Long id, Model model){
        Author author = authorService.getAuthor(id);
        model.addAttribute("author", author);
        model.addAttribute("books", author.getBooks());
        return "author/author-books";
    }

    @GetMapping("/authors/new")
    public String createAuthor(Author author){
        return "author/new-author";
    }

    @PostMapping("/authors/save-author")
    public String saveAuthor(Author author, BindingResult result){
        if(result.hasErrors()){
            return "author/new-author";
        }
        authorService.createAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping("/authors/update/{id}")
    public String updateAuthor(@PathVariable Long id, Model model){
        Author author = authorService.getAuthor(id);
        model.addAttribute("author", author);
        return "author/edit-author";
    }

    @PostMapping("/authors/save-update/{id}")
    public String updateAuthor(@PathVariable Long id, Author author, BindingResult result){
        if(result.hasErrors()){
            return "author/edit-author";
        }
        authorService.updateAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping("/authors/remove/{id}")
    public String deleteAuthor(@PathVariable Long id){
        authorService.removeAuthor(id);
        return "redirect:/authors";
    }
}
