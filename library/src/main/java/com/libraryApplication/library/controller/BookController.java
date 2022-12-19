package com.libraryApplication.library.controller;

import com.libraryApplication.library.entity.Book;
import com.libraryApplication.library.service.AuthorService;
import com.libraryApplication.library.service.BookService;
import com.libraryApplication.library.service.CategoryService;
import com.libraryApplication.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    CategoryService categoryService;

    @Autowired
    PublisherService publisherService;

    @Autowired
    AuthorService authorService;

    @GetMapping("/books")
    public String getAllBooks(Model model){
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book/books";
    }

    @GetMapping("/books/{id}")
    public String getBook(@PathVariable Long id, Model model){
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        return "book/book-details";
    }

    @GetMapping("/books/new")
    public String createBook(Book book, Model model){
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("publishers", publisherService.getAllPublishers());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "book/new-book";
    }
    @PostMapping("/books/save-book")
    public String saveBook(Book book, BindingResult result){
        if(result.hasErrors()){
            return "book/new-book";
        }
        bookService.createBook(book);
        return "redirect:/books";
    }

    @GetMapping("/books/update/{id}")
    public String updateBook(@PathVariable Long id, Model model){
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("publishers", publisherService.getAllPublishers());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "book/edit-book";
    }
    @PostMapping("/books/save-update/{id}")
    public String updateBook(@PathVariable Long id, Book book, BindingResult result){
        if(result.hasErrors()){
            return "book/edit-book";
        }
        bookService.updateBook(book);
        return "redirect:/books";
    }

    @GetMapping("/books/remove/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.removeBook(id);
        return "redirect:/books";
    }
}
