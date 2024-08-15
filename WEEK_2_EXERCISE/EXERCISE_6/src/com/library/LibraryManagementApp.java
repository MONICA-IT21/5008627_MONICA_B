package com.library;

import com.library.model.Book;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class LibraryManagementApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) context.getBean("bookService");

        bookService.addBook("To Kill a Mockingbird", "Harper Lee");
        bookService.addBook("1984", "George Orwell");

        List<Book> books = bookService.getBooks();
        for (Book book : books) {
            System.out.println(book);
        }

        Book book = bookService.getBookByTitle("1984");
        System.out.println("Book found: " + book);

        bookService.removeBook("To Kill a Mockingbird");
    }
}