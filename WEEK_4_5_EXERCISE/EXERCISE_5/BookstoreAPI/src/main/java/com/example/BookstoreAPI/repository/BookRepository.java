package main.java.com.example.BookstoreAPI.repository;

import com.example.bookstoreapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.entity.Book;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findByTitleAndAuthor(String title, String author);
}

@RestController
@RequestMapping("/books")
public class BookController {

    // Example: Create a new book and return custom headers
    @PostMapping
    public ResponseEntity<Book> createBookWithCustomHeaders(@RequestBody Book book) {
        // Logic to save the book

        // Create custom headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "BookStoreAPI");

        return new ResponseEntity<>(book, headers, HttpStatus.CREATED);
    }

    // Example: Get a book by ID with custom headers
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookWithCustomHeaders(@PathVariable Long id) {
        // Logic to retrieve a book by its ID
        Book book = new Book(id, "Example Title", "Author Name", 29.99, "123456789");

        // Create custom headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "BookStoreAPI");

        return new ResponseEntity<>(book, headers, HttpStatus.OK);
    }
}
