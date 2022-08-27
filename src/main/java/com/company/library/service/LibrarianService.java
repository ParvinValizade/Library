package com.company.library.service;

import com.company.library.dto.LibrarianDto;
import com.company.library.dto.converter.LibrarianDtoConverter;
import com.company.library.dto.request.CreateLibrarianRequest;
import com.company.library.model.Librarian;
import com.company.library.repository.LibrarianRepository;
import org.springframework.stereotype.Service;

@Service
public class LibrarianService {

    private final LibrarianRepository repository;
    private final LibrarianDtoConverter converter;

    public LibrarianService(LibrarianRepository repository, LibrarianDtoConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public LibrarianDto createLibrarian(CreateLibrarianRequest request) {
        Librarian librarian = new Librarian(
                request.getName(),
                request.getSurname(),
                request.getEmail(),
                request.getPassword()
        );
        return converter.convert(repository.save(librarian));
    }
}
