package com.library.controller;

import com.library.service.BookService;

public class BookController {

    private BookService service;

    public void getBookDetails() {
        System.out.println("Controller received request.");
        service.displayService();    }
}