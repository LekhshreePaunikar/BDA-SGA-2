package com.example.book_author_management.service;

import com.example.book_author_management.model.Author;
import com.example.book_author_management.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    // Get all authors
    public List<Author> getAllAuthors() {
        // return authorRepository.findAll();
        return authorRepository.findAllByOrderByIdAsc();
    }

    // Save or update an author
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    // Get author by ID
    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }
}
