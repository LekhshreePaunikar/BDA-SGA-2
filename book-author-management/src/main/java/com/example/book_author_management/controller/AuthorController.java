package com.example.book_author_management.controller;

import com.example.book_author_management.model.Author;
import com.example.book_author_management.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    // Display list of authors
    @GetMapping("/authors")
    public String viewAuthorsPage(Model model) {
        model.addAttribute("listAuthors", authorService.getAllAuthors());
        return "authors";
    }

    // Show form to add new author
    @GetMapping("/authors/new")
    public String showNewAuthorForm(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "new_author";
    }

    // Save new author
    @PostMapping("/authors/save")
    public String saveAuthor(@ModelAttribute("author") Author author) {
        authorService.saveAuthor(author);
        return "redirect:/authors";
    }

    // Show form to update author
    @GetMapping("/authors/edit/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Author author = authorService.getAuthorById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author Id:" + id));
        model.addAttribute("author", author);
        return "update_author";
    }

    // Update author
    @PostMapping("/authors/update/{id}")
    public String updateAuthor(@PathVariable("id") long id, @ModelAttribute("author") Author author,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            author.setId(id);
            return "update_author";
        }
        authorService.saveAuthor(author);
        return "redirect:/authors";
    }

}
