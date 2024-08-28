package com.example.bookstore.controller;

import com.example.bookstore.entity.Customer;
import com.example.bookstore.repository.CustomerRepository;
import com.example.bookstore.service.CustomerService;
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

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    void createCustomer_WithValidData_ReturnsCreatedStatus() throws Exception {
        Customer customer = new Customer(1L, "John Doe", "john.doe@example.com", "password");

        when(customerService.saveCustomer(customer)).thenReturn(customer);

        mockMvc.perform(MockMvcRequestBuilders.post("/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customer)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void getCustomer_ById_ReturnsOkStatus() throws Exception {
        Customer customer = new Customer(1L, "John Doe", "john.doe@example.com", "password");

        when(customerService.getCustomerById(1L)).thenReturn(customer);

        mockMvc.perform(MockMvcRequestBuilders.get("/customers/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John Doe"));
    }

    // Additional tests for update and delete can be added similarly
}
