package com.example.book_author_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // Display login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Renders login.html from templates
    }

    @PostMapping("/processLogin")
    public String processLogin(@RequestParam("name") String name,
                               @RequestParam("email") String email,
                               @RequestParam("password") String password,
                               Model model) {

        // Check if the entered credentials are for the admin
        if (name.equals("ADMIN") && email.equals("admin@abc.com") && password.equals("123")) {
            return "redirect:/admin";  // Redirect to the admin page if admin credentials match
        } else {
            // Otherwise, redirect to readbooks.html
            return "redirect:/readbooks";
        }
    }
}
