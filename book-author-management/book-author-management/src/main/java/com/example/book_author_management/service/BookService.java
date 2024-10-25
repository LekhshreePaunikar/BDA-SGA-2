package com.example.book_author_management.service;

import com.example.book_author_management.model.Book;
import com.example.book_author_management.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    // Get all books
    public List<Book> getAllBooks() {
        //return bookRepository.findAll();
        return bookRepository.findAllByOrderByIdAsc();
    }

    // Save or update a book
    public void saveBook(Book book) {
        bookRepository.saveAndFlush(book);  // Ensures immediate flushing of changes
    }

    // Get book by ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Get books by author name
    public List<Book> getBooksByAuthorName(String authorName) {
        return bookRepository.findBooksByAuthorName(authorName);
    }

    // Update book
    public void updateBook(Long id, Book book) {
        bookRepository.save(book);
    }

    // **Delete book by ID**
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
