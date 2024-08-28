package test.java.com.example.BookstoreAPI;

import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
class OnlineBookstoreApplicationTests {

    @Autowired
    private BookService bookService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        // This test ensures that the Spring application context loads without issues
    }

    @Test
    void testCreateBook() {
        // Testing the creation of a new book
        BookDTO book = new BookDTO();
        book.setTitle("New Book");
        book.setAuthor("Author Name");
        book.setPrice(19.99);

        BookDTO savedBook = bookService.createBook(book);
        assertNotNull(savedBook.getId());
    }

    @Test
    void testGetBooks() throws Exception {
        // Testing the retrieval of books via the BookController
        mockMvc.perform(get("/api/books"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$").isArray());
    }
}
