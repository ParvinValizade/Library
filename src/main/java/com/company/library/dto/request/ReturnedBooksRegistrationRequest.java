package com.company.library.dto.request;

public class ReturnedBooksRegistrationRequest {
    private Long userId;
    private Long bookId;

    public Long getUserId() {
        return userId;
    }

    public Long getBookId() {
        return bookId;
    }
}
