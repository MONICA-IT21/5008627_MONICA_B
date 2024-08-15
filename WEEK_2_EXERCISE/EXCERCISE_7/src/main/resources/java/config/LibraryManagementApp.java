package com.library;

package com.library;

import com.library.config.LibraryConfig;
import com.library.service.Book;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LibraryManagementApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(LibraryConfig.class);

        BookService bookService = context.getBean(BookService.class);

        Book book = new Book("123456789", "Spring in Action", "Craig Walls");

        bookService.addBook(book);

        Book retrievedBook = bookService.getBookByIsbn("123456789");
        System.out.println("Retrieved Book: " + retrievedBook);

        bookService.removeBookByIsbn("123456789");

        retrievedBook = bookService.getBookByIsbn("123456789");
        System.out.println("Retrieved Book after removal: " + retrievedBook);
    }
}

