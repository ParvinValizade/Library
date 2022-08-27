package com.company.library.repository;

import com.company.library.model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibrarianRepository extends JpaRepository<Librarian,String> {
    Optional<Librarian> findByEmail(String email);
}
