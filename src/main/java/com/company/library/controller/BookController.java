package com.company.library.controller;

import com.company.library.dto.BookDto;
import com.company.library.dto.request.BookRegistrationRequest;
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
}