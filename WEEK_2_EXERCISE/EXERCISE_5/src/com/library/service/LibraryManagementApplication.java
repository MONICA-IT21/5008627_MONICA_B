package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) context.getBean("bookService");

        // Test the configuration
        bookService.addBook("To Kill a Mockingbird", "Harper Lee");
        bookService.addBook("1984", "George Orwell");

        List<Book> books = bookService.getBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}