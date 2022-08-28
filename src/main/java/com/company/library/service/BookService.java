package com.company.library.service;

import com.company.library.dto.BookDto;
import com.company.library.dto.converter.BookDtoConverter;
import com.company.library.dto.request.BookRegistrationRequest;
import com.company.library.dto.request.UpdateStockRequest;
import com.company.library.exception.BookNotFoundException;
import com.company.library.exception.StockEqualsZeroException;
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

    public BookDto getBookByName(String bookName){
        return converter.convert(findBookByName(bookName));
    }

    public BookDto updateStock(Long bookId, UpdateStockRequest request){
        Book book = findBookById(bookId);
        book.setStock(request.getStock());
        return converter.convert(repository.save(book));
    }

    private Book findBookByName(String bookName){
        return repository.findByName(bookName)
                .orElseThrow(()->new BookNotFoundException("Book couldn't be found by following name: "+bookName));
    }

    protected Book findBookById(Long bookId){
        return repository.findById(bookId)
                .orElseThrow(()->new BookNotFoundException("Book couldn't be found by following id: "+bookId));
    }

    protected void findBookByIdAndCheckStockEqualsZeroOrNot(Long bookId){
       Book book = findBookById(bookId);
       if (book.getStock() != 0){
           book.setStock(book.getStock()-1);
           repository.save(book);
       } else {
           throw new StockEqualsZeroException("This book is currently out of stock");
       }
    }
}
