package main.java.com.example.BookstoreAPI.controller;

import com.example.bookstore.security.JwtUtil;
import com.example.bookstore.model.AuthenticationRequest;
import com.example.bookstore.model.AuthenticationResponse;
import com.example.bookstore.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping("/authenticate")
    public AuthenticationResponse createToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        final String jwtToken = jwtUtil.generateToken(userDetailsService.loadUserByUsername(authenticationRequest.getUsername()));

        return new AuthenticationResponse(jwtToken);
    }
}
