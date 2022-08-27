package com.company.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class LibrarianAlreadyExistException extends RuntimeException{
    public LibrarianAlreadyExistException(String message) {
        super(message);
    }
}
