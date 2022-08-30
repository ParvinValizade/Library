package com.company.library.controller;

import com.company.library.dto.BookDto;
import com.company.library.dto.request.BookRegistrationRequest;
import com.company.library.dto.request.SearchBookByCategoryNameRequest;
import com.company.library.dto.request.UpdateStockRequest;
import com.company.library.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("bookRegistration")
    @Operation(summary = "Book Registration", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<BookDto> bookRegistration(@RequestBody BookRegistrationRequest request){
        return ResponseEntity.ok(bookService.bookRegistration(request));
    }

    @GetMapping("getAllBooks")
    @Operation(summary = "Show All Books", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<List<BookDto>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("searchBookByName/{bookName}")
    @Operation(summary = "Search Book", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<BookDto> getBookByName(@PathVariable String bookName){
        return ResponseEntity.ok(bookService.getBookByName(bookName));
    }

    @PutMapping("updateStock/{bookId}")
    @Operation(summary = "Update Stock", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<BookDto> updateStock(@PathVariable Long bookId,
                                               @RequestBody UpdateStockRequest request){
        return ResponseEntity.ok(bookService.updateStock(bookId,request));
    }

    @GetMapping("getAllBooksByCategoryName/{categoryName}")
    @Operation(summary = "Find all books by categoryName", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<List<BookDto>> getAllBooksByCategoryName(@PathVariable SearchBookByCategoryNameRequest categoryName){
        return ResponseEntity.ok(bookService.getAllBooksByCategoryName(categoryName));
    }
}
