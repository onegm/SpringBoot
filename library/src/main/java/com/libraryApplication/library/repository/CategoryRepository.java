package com.libraryApplication.library.repository;

import com.libraryApplication.library.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}