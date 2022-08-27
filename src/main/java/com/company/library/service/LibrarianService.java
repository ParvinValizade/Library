package com.company.library.service;

import com.company.library.dto.LibrarianDto;
import com.company.library.dto.converter.LibrarianDtoConverter;
import com.company.library.dto.request.CreateLibrarianRequest;
import com.company.library.dto.request.SignInRequest;
import com.company.library.exception.LibrarianAlreadyExistException;
import com.company.library.exception.LibrarianNotFoundException;
import com.company.library.model.Librarian;
import com.company.library.repository.LibrarianRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibrarianService {

    private final LibrarianRepository repository;
    private final LibrarianDtoConverter converter;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationService authenticationService;

    public LibrarianService(LibrarianRepository repository,
                            LibrarianDtoConverter converter,
                            PasswordEncoder passwordEncoder,
                            AuthenticationService authenticationService) {
        this.repository = repository;
        this.converter = converter;
        this.passwordEncoder = passwordEncoder;
        this.authenticationService = authenticationService;
    }

    public LibrarianDto createLibrarian(CreateLibrarianRequest request) {
        checkLibrarianIsAlreadyExistOrNot(request.getEmail());
        Librarian librarian = new Librarian(
                request.getName(),
                request.getSurname(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword())
        );
        return converter.convert(repository.save(librarian));
    }

    public String signIn(SignInRequest request){
        return authenticationService.singInAndReturnJWT(request);
    }

    public LibrarianDto findLibrarianByEmail(String email){
        return converter.convert(findLibrarian(email));
    }


    private void checkLibrarianIsAlreadyExistOrNot(String email){
        Optional<Librarian> librarian = repository.findByEmail(email);
        librarian.ifPresent(user1 -> {throw new LibrarianAlreadyExistException("Librarian Already Exist");});
    }
    private Librarian findLibrarian(String email){
        return repository.findByEmail(email)
                .orElseThrow(()->new LibrarianNotFoundException("Librarian couldn't be found by following email: "
                        +email));
    }
}
