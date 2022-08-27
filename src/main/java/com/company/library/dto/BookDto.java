package com.company.library.dto;

public class BookDto {

    private Long id;

    private String name;
    private String author;

    private String categoryName;
    private Integer stock;

    public BookDto(Long id, String name, String author, String categoryName, Integer stock) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.categoryName = categoryName;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Integer getStock() {
        return stock;
    }
}
