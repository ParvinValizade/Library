package com.company.library.dto.converter;

import com.company.library.dto.UserDto;
import com.company.library.model.Users;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoConverter {

    public UserDto convert(Users from){
        return new UserDto(
                from.getId(),
                from.getName(),
                from.getSurname()
        );
    }

    public List<UserDto> convert(List<Users> fromList){
        return fromList.stream()
                .map(this::convert).collect(Collectors.toList());
    }
}
