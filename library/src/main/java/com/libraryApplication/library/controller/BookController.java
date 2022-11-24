package com.libraryApplication.library.controller;

import com.libraryApplication.library.entity.Book;
import com.libraryApplication.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public String getAllBooks(Model model){
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable Long id){
        return bookService.getBook(id);
    }

    @PostMapping("/books/new")
    public void createBook(@RequestBody Book book){
        bookService.createBook(book);
    }

    @PutMapping("/books/update")
    public void updateBook(@RequestBody Book book){
        bookService.updateBook(book);
    }

    @DeleteMapping("/books/remove/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.removeBook(id);
    }
}
