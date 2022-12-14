package com.company.library.controller;

import com.company.library.dto.LibrarianDto;
import com.company.library.dto.request.CreateLibrarianRequest;
import com.company.library.dto.request.SignInRequest;
import com.company.library.service.LibrarianService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/librarian")
public class LibrarianController {

    private final LibrarianService librarianService;

    public LibrarianController(LibrarianService librarianService) {
        this.librarianService = librarianService;
    }

    @PostMapping("sign-up")
    public ResponseEntity<LibrarianDto> signUp(@RequestBody CreateLibrarianRequest request){
        return ResponseEntity.ok(librarianService.createLibrarian(request));
    }

    @PostMapping("sign-in")
    public ResponseEntity<String> signIn(@RequestBody SignInRequest librarian){
        return new ResponseEntity<>(librarianService.signIn(librarian), HttpStatus.OK);
    }

}
