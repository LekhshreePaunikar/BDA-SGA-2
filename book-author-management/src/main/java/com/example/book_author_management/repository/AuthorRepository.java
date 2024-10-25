package com.example.book_author_management.repository;

import com.example.book_author_management.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Return all authors ordered by ID
    List<Author> findAllByOrderByIdAsc();
}
