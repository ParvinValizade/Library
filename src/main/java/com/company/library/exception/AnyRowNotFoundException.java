package com.company.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AnyRowNotFoundException extends RuntimeException{
    public AnyRowNotFoundException(String message) {
        super(message);
    }
}
