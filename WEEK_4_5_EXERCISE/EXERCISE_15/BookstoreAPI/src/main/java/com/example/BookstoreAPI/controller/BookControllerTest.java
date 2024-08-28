package com.example.bookstore.controller;

import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.Mockito.when;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    void createBook_WithValidData_ReturnsCreatedStatus() throws Exception {
        Book book = new Book(1L, "The Alchemist", "Paulo Coelho", 19.99, "1234567890");

        when(bookService.saveBook(book)).thenReturn(book);

        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void getBook_ById_ReturnsOkStatus() throws Exception {
        Book book = new Book(1L, "The Alchemist", "Paulo Coelho", 19.99, "1234567890");

        when(bookService.getBookById(1L)).thenReturn(book);

        mockMvc.perform(MockMvcRequestBuilders.get("/books/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("The Alchemist"));
    }

    // Additional tests for update and delete can be added similarly
}
