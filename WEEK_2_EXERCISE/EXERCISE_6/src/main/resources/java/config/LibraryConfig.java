package com.library.config;

import com.library.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibraryConfig {

    @Bean
    public BookService bookService() {
        return new BookService();
    }
}
