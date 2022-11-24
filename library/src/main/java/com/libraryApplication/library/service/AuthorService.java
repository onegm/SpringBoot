package com.libraryApplication.library.service;

import com.libraryApplication.library.entity.Author;
import com.libraryApplication.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public void createAuthor(Author author){
        authorRepository.save(author);
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthor(Long id){
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not Found"));
    }

    public void updateAuthor(Author author){
        authorRepository.save(author);
    }

    public void removeAuthor(Long id){
        authorRepository.deleteById(id);
    }
}
