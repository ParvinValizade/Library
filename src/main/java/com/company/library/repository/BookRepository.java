package com.company.library.repository;

import com.company.library.model.Book;
import com.company.library.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {
    Optional<Book> findByName(String bookName);
    List<Book> findAllByCategory(Category category);
}
