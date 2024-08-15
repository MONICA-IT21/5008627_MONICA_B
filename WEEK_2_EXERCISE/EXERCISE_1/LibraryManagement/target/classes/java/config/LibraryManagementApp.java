
package com.library;

import com.library.config.LibraryConfig;
import com.library.service.Book;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LibraryManagementApp {

    public static void main(String[] args) {
        // Load the Spring context
        ApplicationContext context = new AnnotationConfigApplicationContext(LibraryConfig.class);

        // Retrieve the BookService bean from the context
        BookService bookService = context.getBean(BookService.class);

        // Create a new Book instance
        Book book = new Book("123456789", "Spring in Action", "Craig Walls");

        // Add the book to the BookService
        bookService.addBook(book);

        // Retrieve and print the book from the BookService
        Book retrievedBook = bookService.getBookByIsbn("123456789");
        System.out.println("Retrieved Book: " + retrievedBook);

        // Remove the book from the BookService
        bookService.removeBookByIsbn("123456789");

        // Try to retrieve the book again
        retrievedBook = bookService.getBookByIsbn("123456789");
        System.out.println("Retrieved Book after removal: " + retrievedBook);
    }
}

