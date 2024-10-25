package com.example.book_author_management.controller;

import com.example.book_author_management.model.Author;
import com.example.book_author_management.model.Book;
import com.example.book_author_management.service.AuthorService;
import com.example.book_author_management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    // Display list of books
    @GetMapping("/books")
    public String viewBooksPage(Model model) {
        model.addAttribute("listBooks", bookService.getAllBooks());
        return "books";
    }

    // Show form to add new book
    @GetMapping("/books/new")
    public String showNewBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("listAuthors", authorService.getAllAuthors());
        return "new_book";
    }

    // Save new book
    @PostMapping("/books/save")
    public String saveBook(@ModelAttribute("book") Book book) {
        // Fetch the author from the database
        Author author = authorService.getAuthorById(book.getAuthor().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid author Id:" + book.getAuthor().getId()));
        book.setAuthor(author);
        bookService.saveBook(book);
        return "redirect:/books";
    }

    // Show form to update book
    @GetMapping("/books/edit/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Book book = bookService.getBookById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));

        // Debugging: print the book details
        System.out.println("Editing Book ID: " + book.getId() + ", Title: " + book.getTitle());

        model.addAttribute("book", book);
        model.addAttribute("listAuthors", authorService.getAllAuthors());  // Ensure this is not empty or null
        return "update_book";  // This should map to 'update_book.html'
    }

    // Update book
    @PostMapping("/books/update/{id}")
    public String updateBook(@PathVariable("id") long id, @ModelAttribute("book") Book book,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            book.setId(id);
            model.addAttribute("listAuthors", authorService.getAllAuthors());
            return "update_book";
        }

        // Debugging: Log the book and author data before updating
        System.out.println("Updating Book ID: " + book.getId() + ", Title: " + book.getTitle());
        System.out.println("Selected Author ID: " + book.getAuthor().getId());

        // Fetch the author and ensure it's attached to the persistence context
        Author author = authorService.getAuthorById(book.getAuthor().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid author Id:" + book.getAuthor().getId()));

        book.setAuthor(author);  // Reattach the author to the book to avoid detached entity issues

        // Debugging: Log after author is set
        System.out.println("Author for Book set successfully: " + author.getName());

        // Use saveAndFlush for immediate persistence
        bookService.saveBook(book);

        System.out.println("Book updated successfully.");
        return "redirect:/books";
    }

    // View books by author name
    @GetMapping("/books/author")
    public String viewBooksByAuthor(@RequestParam("name") String authorName, Model model) {
        model.addAttribute("listBooks", bookService.getBooksByAuthorName(authorName));
        return "books";
    }

    // **Delete book**
    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") long id) {
        // Call delete book method from the service
        bookService.deleteBookById(id);
        return "redirect:/books";
    }
}
