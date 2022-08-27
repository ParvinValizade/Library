package com.company.library.dto.request;


public class BookRegistrationRequest {
    private String name;
    private String author;

    private Long categoryId;
    private Integer stock;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Integer getStock() {
        return stock;
    }
}
