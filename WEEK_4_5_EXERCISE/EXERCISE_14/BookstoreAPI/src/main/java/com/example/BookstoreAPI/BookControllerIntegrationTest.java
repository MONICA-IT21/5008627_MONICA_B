package main.java.com.example.BookstoreAPI;

import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        // Initializes MockMvc with the web application context
        mockMvc = MockMvcBuilders.webAppContextSetup((WebApplicationContext) mockMvc).build();
    }

    @Test
    void createBook_WithValidData_ReturnsCreatedStatus() throws Exception {
        // Define a book object
        Book book = new Book(null, "The Alchemist", "Paulo Coelho", 19.99, "1234567890");

        // Perform a POST request to create a new book
        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"The Alchemist\",\"author\":\"Paulo Coelho\",\"price\":19.99,\"isbn\":\"1234567890\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    void getBook_ById_ReturnsOkStatus() throws Exception {
        // Define and save a book object
        Book book = new Book(null, "The Alchemist", "Paulo Coelho", 19.99, "1234567890");
        Book savedBook = bookRepository.save(book);

        // Perform a GET request to retrieve the book by its ID
        mockMvc.perform(MockMvcRequestBuilders.get("/books/" + savedBook.getId()))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("The Alchemist"));
    }

    @Test
    void updateBook_WithValidData_ReturnsOkStatus() throws Exception {
        // Define and save a book object
        Book book = new Book(null, "The Alchemist", "Paulo Coelho", 19.99, "1234567890");
        Book savedBook = bookRepository.save(book);

        // Define the updated book data
        String updatedBookJson = "{\"title\":\"The Alchemist Updated\",\"author\":\"Paulo Coelho\",\"price\":29.99,\"isbn\":\"0987654321\"}";

        // Perform a PUT request to update the book
        mockMvc.perform(MockMvcRequestBuilders.put("/books/" + savedBook.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedBookJson))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("The Alchemist Updated"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(29.99));
    }

    @Test
    void deleteBook_ById_ReturnsNoContentStatus() throws Exception {
        // Define and save a book object
        Book book = new Book(null, "The Alchemist", "Paulo Coelho", 19.99, "1234567890");
        Book savedBook = bookRepository.save(book);

        // Perform a DELETE request to remove the book
        mockMvc.perform(MockMvcRequestBuilders.delete("/books/" + savedBook.getId()))
                .andExpect(status().isNoContent());
    }
}
