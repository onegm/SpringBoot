package com.libraryApplication.library.controller;

import com.libraryApplication.library.entity.Author;
import com.libraryApplication.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/authors")
    public String getAllAuthors(Model model){
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors";
    }

    @GetMapping("/authors/{id}")
    public Author getAuthor(@PathVariable Long id){
        return authorService.getAuthor(id);
    }

    @PostMapping("/authors/new")
    public void createAuthor(@RequestBody Author author){
        authorService.createAuthor(author);
    }

    @PutMapping("/authors/update")
    public void updateAuthor(@RequestBody Author author){
        authorService.updateAuthor(author);
    }

    @DeleteMapping("/authors/remove/{id}")
    public void deleteAuthor(@PathVariable Long id){
        authorService.removeAuthor(id);
    }
}
