package com.company.library.controller;

import com.company.library.service.StatisticsOfOperationsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/operations")
public class StatisticsOfOperationsController {
    private final StatisticsOfOperationsService operationsService;

    public StatisticsOfOperationsController(StatisticsOfOperationsService operationsService) {
        this.operationsService = operationsService;
    }

    @GetMapping("countOfGivenBooks/{date}")
    @Operation(summary = "Number of books given to users during the day",
            security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<String> countOfGivenBooks(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        return ResponseEntity.ok(operationsService.countOfGivenBooks(date));
    }

    @GetMapping("countOfReturnedBooks/{date}")
    @Operation(summary = "Number of books returned by users during the day",
            security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<String> countOfReturnedBooks(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        return ResponseEntity.ok(operationsService.countOfReturnedBooks(date));
    }
}
