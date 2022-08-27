package com.company.library.dto;

import java.time.LocalDate;

public class BooksOfUserDto {
    private Long userId;
    private Long bookId;
    private LocalDate dateOfGivingToUser;
    private LocalDate dateOfReturnFromUser;

    public BooksOfUserDto(Long userId, Long bookId, LocalDate dateOfGivingToUser, LocalDate dateOfReturnFromUser) {
        this.userId = userId;
        this.bookId = bookId;
        this.dateOfGivingToUser = dateOfGivingToUser;
        this.dateOfReturnFromUser = dateOfReturnFromUser;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public LocalDate getDateOfGivingToUser() {
        return dateOfGivingToUser;
    }

    public LocalDate getDateOfReturnFromUser() {
        return dateOfReturnFromUser;
    }
}
