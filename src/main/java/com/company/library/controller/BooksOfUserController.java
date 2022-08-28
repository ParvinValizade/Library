package com.company.library.controller;

import com.company.library.dto.BooksOfUserDto;
import com.company.library.dto.request.AssignBookToUserRequest;
import com.company.library.dto.request.ReturnedBooksRegistrationRequest;
import com.company.library.service.BooksOfUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("booksOfUser")
public class BooksOfUserController {
    private final BooksOfUserService booksOfUserService;

    public BooksOfUserController(BooksOfUserService booksOfUserService) {
        this.booksOfUserService = booksOfUserService;
    }

    @PostMapping("assignBookToUser")
    @Operation(summary = "Assign book to User", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<BooksOfUserDto> assignBookToUser(@RequestBody AssignBookToUserRequest request){
        return ResponseEntity.ok(booksOfUserService.assignBookToUser(request));
    }

    @PutMapping("returnedBooksRegistration")
    @Operation(summary = "Returned Book Registration", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<List<BooksOfUserDto>> returnedBooksRegistration(
            @RequestBody ReturnedBooksRegistrationRequest request){
        return ResponseEntity.ok(booksOfUserService.returnedBooksRegistration(request));
    }
}
