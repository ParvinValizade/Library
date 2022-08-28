package com.company.library.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "books_of_user")
public class BooksOfUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id",unique = false)
    private Long userId;

    @Column(name = "book_id",unique = false)
    private Long bookId;

    @Column(name = "date_of_giving_to_user")
    private LocalDate dateOfGivingToUser;

    @Column(name = "date_of_return_from_user")
    private LocalDate dateOfReturnFromUser;

    public BooksOfUser() {
    }

    public BooksOfUser(Long id, Long userId, Long bookId, LocalDate dateOfGivingToUser, LocalDate dateOfReturnFromUser) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.dateOfGivingToUser = dateOfGivingToUser;
        this.dateOfReturnFromUser = dateOfReturnFromUser;
    }

    public BooksOfUser(Long userId, Long bookId, LocalDate dateOfGivingToUser) {
        this.userId = userId;
        this.bookId = bookId;
        this.dateOfGivingToUser = dateOfGivingToUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public LocalDate getDateOfGivingToUser() {
        return dateOfGivingToUser;
    }

    public void setDateOfGivingToUser(LocalDate dateOfGivingToUser) {
        this.dateOfGivingToUser = dateOfGivingToUser;
    }

    public LocalDate getDateOfReturnFromUser() {
        return dateOfReturnFromUser;
    }

    public void setDateOfReturnFromUser(LocalDate dateOfReturnFromUser) {
        this.dateOfReturnFromUser = dateOfReturnFromUser;
    }
}
