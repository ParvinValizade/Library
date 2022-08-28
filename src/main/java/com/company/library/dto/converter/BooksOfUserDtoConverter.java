package com.company.library.dto.converter;

import com.company.library.dto.BooksOfUserDto;
import com.company.library.model.BooksOfUser;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BooksOfUserDtoConverter {

    public BooksOfUserDto convert(BooksOfUser from){
        return new BooksOfUserDto(
                from.getUserId(),
                from.getBookId(),
                from.getDateOfGivingToUser(),
                from.getDateOfReturnFromUser()
        );
    }

    public List<BooksOfUserDto> convert(List<BooksOfUser> fomList){
        return fomList.stream()
                .map(this::convert).collect(Collectors.toList());
    }
}
