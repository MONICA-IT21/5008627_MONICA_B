package main.java.com.example.BookstoreAPI.repository;

import com.example.bookstoreapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bookstore.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
    Customer findByEmail(String email);
}
