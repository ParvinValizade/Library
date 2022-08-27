package com.company.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LibrarianNotFoundException extends RuntimeException{
    public LibrarianNotFoundException(String message) {
        super(message);
    }
}
