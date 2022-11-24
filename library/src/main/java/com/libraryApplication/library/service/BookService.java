package com.libraryApplication.library.service;

import com.libraryApplication.library.entity.Book;
import com.libraryApplication.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void createBook(Book book){
        bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBook(Long id){
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not Found"));
    }

    public void updateBook(Book book){
        bookRepository.save(book);
    }

    public void removeBook(Long id){
        bookRepository.deleteById(id);
    }
}
