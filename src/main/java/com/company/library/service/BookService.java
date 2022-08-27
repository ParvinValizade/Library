package com.company.library.service;

import com.company.library.dto.BookDto;
import com.company.library.dto.converter.BookDtoConverter;
import com.company.library.dto.request.BookRegistrationRequest;
import com.company.library.model.Book;
import com.company.library.model.Category;
import com.company.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;
    private final BookDtoConverter converter;

    private final CategoryService categoryService;

    public BookService(BookRepository repository, BookDtoConverter converter, CategoryService categoryService) {
        this.repository = repository;
        this.converter = converter;
        this.categoryService = categoryService;
    }

    public BookDto bookRegistration(BookRegistrationRequest request){
        Category category = categoryService.findCategoryById(request.getCategoryId());
        Book book = new Book(
                request.getName(),
                request.getAuthor(),
                category,
                request.getStock()
        );
        return converter.convert(repository.save(book));
    }

    public List<BookDto> getAllBooks(){
        return converter.concert(repository.findAll());
    }
}
