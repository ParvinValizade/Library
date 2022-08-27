package com.company.library.repository;

import com.company.library.model.BooksOfUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksOfUserRepository extends JpaRepository<BooksOfUser,Long> {
}
