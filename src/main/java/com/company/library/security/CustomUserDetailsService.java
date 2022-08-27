package com.company.library.security;

import com.company.library.dto.LibrarianDto;
import com.company.library.service.LibrarianService;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final LibrarianService librarianService;

    public CustomUserDetailsService(@Lazy LibrarianService librarianService) {
        this.librarianService = librarianService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LibrarianDto librarian = librarianService.findLibrarianByEmail(username);
        return new UserPrincipal(librarian.getId(),librarian.getEmail(),librarian.getPassword());
    }
}
