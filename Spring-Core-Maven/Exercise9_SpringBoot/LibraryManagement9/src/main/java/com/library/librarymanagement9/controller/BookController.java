package com.library.librarymanagement9.controller;

import com.library.librarymanagement9.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @GetMapping("/book")
    public Book getBook() {
        return new Book(1, "Spring Boot", "Varsha");
    }
}