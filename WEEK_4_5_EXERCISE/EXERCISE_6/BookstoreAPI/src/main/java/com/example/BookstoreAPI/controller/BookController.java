package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.bookstoreapi.entity.Book;
import org.springframework.http.HttpStatus;
import com.example.bookstore.exception.BookNotFoundException;
import com.example.bookstore.exception.InvalidBookException;


import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Endpoint to fetch a book by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.findBookById(id);
        return ResponseEntity.ok(book);
    }

    // Endpoint to filter books by title and author
@GetMapping
public ResponseEntity<List<Book>> getBooksByQuery(
        @RequestParam(required = false) String title,
        @RequestParam(required = false) String author) {
    List<Book> books = bookService.findBooksByQuery(title, author);
    return ResponseEntity.ok(books);
}

@PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Custom status code
    public Book createBook(@RequestBody Book book) {
        // Logic to save the book
        return book;
    }

    // Example: Get a book by ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable Long id) {
        // Logic to retrieve a book by its ID
        return new Book(id, "Example Title", "Author Name", 29.99, "123456789");
    }

}

private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        Book book = bookService.findBookById(id);
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + id + " not found.");
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        if (book == null || book.getTitle() == null || book.getAuthor() == null) {
            throw new InvalidBookException("Book title and author must not be null.");
        }
        Book savedBook = bookService.saveBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }



