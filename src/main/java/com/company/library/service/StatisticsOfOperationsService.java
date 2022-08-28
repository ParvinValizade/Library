package com.company.library.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StatisticsOfOperationsService {
    private final BooksOfUserService booksOfUserService;

    public StatisticsOfOperationsService(BooksOfUserService booksOfUserService) {
        this.booksOfUserService = booksOfUserService;
    }

    public String countOfGivenBooks(LocalDate date){
        return date + " tarixində istifadəçilərə verilən kitabların sayı: "
                + booksOfUserService.countOfGivenBooks(date);
    }

    public String countOfReturnedBooks(LocalDate date){
        return date + " tarixində istifadəçilərdən təhvil alınan kitabların sayı: "
                +booksOfUserService.countOfReturnedBooks(date);
    }
}
