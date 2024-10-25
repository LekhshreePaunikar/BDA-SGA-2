// AdminController.java
package com.example.book_author_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    // Render the admin dashboard page
    @GetMapping("/admin")
    public String showAdminDashboard() {
        return "admin";  // This maps to admin.html in your templates directory
    }
}
