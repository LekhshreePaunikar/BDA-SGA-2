package com.example.book_author_management.repository;

import com.example.book_author_management.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // Custom query to perform an inner join between Book and Author
    @Query("SELECT b FROM Book b INNER JOIN b.author a WHERE a.name = :authorName")
    List<Book> findBooksByAuthorName(@Param("authorName") String authorName);

    // Return all books ordered by ID
    List<Book> findAllByOrderByIdAsc();
}
