package main.java.com.example.BookstoreAPI.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private double price;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDTO {
    private Long id;

    @JsonProperty("book_title")
    private String title;

    private String author;
    private double price;

  
}
}



