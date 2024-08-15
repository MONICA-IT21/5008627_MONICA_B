package com.example.employeemanagement.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // For simplicity, return a static value or integrate with Spring Security
        return Optional.of("system"); // You can replace this with the logged-in user's ID
    }
}
