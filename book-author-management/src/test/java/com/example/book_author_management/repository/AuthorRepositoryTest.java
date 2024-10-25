package com.example.book_author_management.repository;

import com.example.book_author_management.model.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void testSaveAuthor() {
        Author author = new Author("Test Author");
        authorRepository.save(author);

        assertThat(author.getId()).isNotNull();
        assertThat(author.getName()).isEqualTo("Test Author");
    }

    @Test
    public void testFindById() {
        Author author = new Author("Test Author");
        authorRepository.save(author);

        Optional<Author> foundAuthor = authorRepository.findById(author.getId());

        assertThat(foundAuthor.isPresent()).isTrue();
        assertThat(foundAuthor.get().getName()).isEqualTo("Test Author");
    }
}
