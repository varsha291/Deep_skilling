package com.library.controller;

import com.library.service.BookService;

public class BookController {

    private BookService bookService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public void displayController() {
        System.out.println("BookController Bean Created Successfully.");
        bookService.displayService();
    }
}