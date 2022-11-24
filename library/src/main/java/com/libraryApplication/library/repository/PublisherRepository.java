package com.libraryApplication.library.repository;

import com.libraryApplication.library.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}