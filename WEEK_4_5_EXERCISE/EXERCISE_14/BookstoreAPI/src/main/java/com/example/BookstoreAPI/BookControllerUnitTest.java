package main.java.com.example.BookstoreAPI;

import com.example.bookstore.controller.BookController;
import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepository;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookController bookController;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createBook_WithValidData_ReturnsCreatedStatus() throws Exception {
        Book book = new Book(null, "The Alchemist", "Paulo Coelho", 19.99, "1234567890");
        when(bookRepository.save(book)).thenReturn(new Book(1L, "The Alchemist", "Paulo Coelho", 19.99, "1234567890"));

        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("The Alchemist"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("Paulo Coelho"));
    }

    @Test
    void getBook_ById_ReturnsOkStatus() throws Exception {
        Book book = new Book(1L, "The Alchemist", "Paulo Coelho", 19.99, "1234567890");
        when(bookRepository.findById(1L)).thenReturn(java.util.Optional.of(book));

        mockMvc.perform(MockMvcRequestBuilders.get("/books/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("The Alchemist"));
    }

    @Test
    void updateBook_WithValidData_ReturnsOkStatus() throws Exception {
        Book book = new Book(1L, "The Alchemist", "Paulo Coelho", 19.99, "1234567890");
        when(bookRepository.findById(1L)).thenReturn(java.util.Optional.of(book));
        when(bookRepository.save(book)).thenReturn(new Book(1L, "The Alchemist Updated", "Paulo Coelho", 29.99, "0987654321"));

        Book updatedBook = new Book(1L, "The Alchemist Updated", "Paulo Coelho", 29.99, "0987654321");

        mockMvc.perform(MockMvcRequestBuilders.put("/books/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedBook)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("The Alchemist Updated"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(29.99));
    }

    @Test
    void deleteBook_ById_ReturnsNoContentStatus() throws Exception {
        Book book = new Book(1L, "The Alchemist", "Paulo Coelho", 19.99, "1234567890");
        when(bookRepository.findById(1L)).thenReturn(java.util.Optional.of(book));

        mockMvc.perform(MockMvcRequestBuilders.delete("/books/1"))
                .andExpect(status().isNoContent());
    }
}
