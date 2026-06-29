package com.library.librarymanagement9.repository;

import com.library.librarymanagement9.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}