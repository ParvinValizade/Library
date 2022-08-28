package com.company.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StockEqualsZeroException extends RuntimeException{
    public StockEqualsZeroException(String message) {
        super(message);
    }
}
