package com.company.library.repository;

import com.company.library.model.BooksOfUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BooksOfUserRepository extends JpaRepository<BooksOfUser,Long> {
    Integer countByDateOfGivingToUserEquals(LocalDate date);
    Integer countByDateOfReturnFromUserEquals(LocalDate date);
    List<BooksOfUser> findByUserIdAndBookId(Long userId,Long bookId);
}
