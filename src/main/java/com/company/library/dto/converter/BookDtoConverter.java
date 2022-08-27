package com.company.library.dto.converter;

import com.company.library.dto.BookDto;
import com.company.library.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookDtoConverter {

    public BookDto convert(Book from){
        return new BookDto(
                from.getId(),
                from.getName(),
                from.getAuthor(),
                from.getCategory().getName(),
                from.getStock()
        );
    }

    public List<BookDto> concert(List<Book> fromList){
        return fromList.stream()
                .map(this::convert).collect(Collectors.toList());
    }
}
