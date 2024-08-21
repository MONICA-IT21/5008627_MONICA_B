package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
