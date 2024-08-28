package test.java.com.example.BookstoreAPI;

import com.example.bookstore.dto.CustomerDTO;
import com.example.bookstore.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Autowired
    private ObjectMapper objectMapper;

    private CustomerDTO sampleCustomer;

    @BeforeEach
    void setUp() {
        sampleCustomer = new CustomerDTO();
        sampleCustomer.setId(1L);
        sampleCustomer.setFirstName("Amit");
        sampleCustomer.setLastName("Sharma");
        sampleCustomer.setEmail("amit.sharma@example.com");
    }

    @Test
    void testCreateCustomer() throws Exception {
        when(customerService.createCustomer(any(CustomerDTO.class))).thenReturn(sampleCustomer);

        mockMvc.perform(post("/api/customers")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(sampleCustomer)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("Amit"))
                .andExpect(jsonPath("$.lastName").value("Sharma"))
                .andExpect(jsonPath("$.email").value("amit.sharma@example.com"));
    }

    @Test
    void testGetCustomerById() throws Exception {
        when(customerService.getCustomerById(1L)).thenReturn(sampleCustomer);

        mockMvc.perform(get("/api/customers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("Amit"))
                .andExpect(jsonPath("$.lastName").value("Sharma"))
                .andExpect(jsonPath("$.email").value("amit.sharma@example.com"));
    }

    @Test
    void testGetAllCustomers() throws Exception {
        when(customerService.getAllCustomers()).thenReturn(List.of(sampleCustomer));

        mockMvc.perform(get("/api/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].firstName").value("Amit"))
                .andExpect(jsonPath("$[0].lastName").value("Sharma"))
                .andExpect(jsonPath("$[0].email").value("amit.sharma@example.com"));
    }

    @Test
    void testUpdateCustomer() throws Exception {
        CustomerDTO updatedCustomer = new CustomerDTO();
        updatedCustomer.setId(1L);
        updatedCustomer.setFirstName("Amit");
        updatedCustomer.setLastName("Kumar");
        updatedCustomer.setEmail("amit.kumar@example.com");

        when(customerService.updateCustomer(any(Long.class), any(CustomerDTO.class))).thenReturn(updatedCustomer);

        mockMvc.perform(put("/api/customers/1")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(updatedCustomer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("Amit"))
                .andExpect(jsonPath("$.lastName").value("Kumar"))
                .andExpect(jsonPath("$.email").value("amit.kumar@example.com"));
    }

    @Test
    void testDeleteCustomer() throws Exception {
        mockMvc.perform(delete("/api/customers/1"))
                .andExpect(status().isNoContent());
    }
}
