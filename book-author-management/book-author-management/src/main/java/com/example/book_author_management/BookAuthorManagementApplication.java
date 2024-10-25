package com.example.book_author_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BookAuthorManagementApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BookAuthorManagementApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BookAuthorManagementApplication.class);
	}
}
