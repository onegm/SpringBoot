package com.libraryApplication.library.repository;

import com.libraryApplication.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}