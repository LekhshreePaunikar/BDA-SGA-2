package com.example.book_author_management.repository;

import com.example.book_author_management.model.Author;
import com.example.book_author_management.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testFindBooksByAuthorName() {
        Author author = new Author("Author Test");
        authorRepository.save(author);

        Book book1 = new Book("Book 1", author);
        Book book2 = new Book("Book 2", author);
        bookRepository.save(book1);
        bookRepository.save(book2);

        List<Book> books = bookRepository.findBooksByAuthorName("Author Test");

        assertThat(books.size()).isEqualTo(2);
    }
}
