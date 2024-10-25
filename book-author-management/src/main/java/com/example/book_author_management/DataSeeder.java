package com.example.book_author_management;

import com.example.book_author_management.model.Author;
import com.example.book_author_management.model.Book;
import com.example.book_author_management.repository.AuthorRepository;
import com.example.book_author_management.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataSeeder(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Check if data already exists
        if (authorRepository.count() == 0 && bookRepository.count() == 0) {
            // Create Authors
            Author author1 = new Author("Author One");
            Author author2 = new Author("Author Two");
            Author author3 = new Author("Author Three");
            Author author4 = new Author("Author Four");
            Author author5 = new Author("Author Five");
            Author author6 = new Author("Author Six");
            Author author7 = new Author("Author Seven");
            Author author8 = new Author("Author Eight");
            Author author9 = new Author("Author Nine");
            Author author10 = new Author("Author Ten");

            // Save authors
            authorRepository.saveAll(Arrays.asList(author1, author2, author3, author4, author5,
                    author6, author7, author8, author9, author10));

            // Create Books
            Book book1 = new Book("Book One", author1);
            Book book2 = new Book("Book Two", author2);
            Book book3 = new Book("Book Three", author3);
            Book book4 = new Book("Book Four", author4);
            Book book5 = new Book("Book Five", author5);
            Book book6 = new Book("Book Six", author6);
            Book book7 = new Book("Book Seven", author7);
            Book book8 = new Book("Book Eight", author8);
            Book book9 = new Book("Book Nine", author9);
            Book book10 = new Book("Book Ten", author10);

            // Save books
            bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4, book5,
                    book6, book7, book8, book9, book10));
        }
    }
}
