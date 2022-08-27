package com.company.library.dto.converter;

import com.company.library.dto.LibrarianDto;
import com.company.library.model.Librarian;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LibrarianDtoConverter {

    public LibrarianDto convert(Librarian from){
        return new LibrarianDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getEmail(),
                from.getPassword()
        );
    }

    public List<LibrarianDto> convert(List<Librarian> fromList){
        return fromList.stream()
                .map(this::convert).collect(Collectors.toList());
    }
}
