package com.libraryApplication.library.repository;

import com.libraryApplication.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}