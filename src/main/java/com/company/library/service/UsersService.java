package com.company.library.service;

import com.company.library.dto.UserDto;
import com.company.library.dto.converter.UserDtoConverter;
import com.company.library.dto.request.UserRegistrationRequest;
import com.company.library.exception.UserAlreadyExistException;
import com.company.library.model.Users;
import com.company.library.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository repository;
    private final UserDtoConverter converter;

    public UsersService(UsersRepository repository, UserDtoConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public UserDto userRegistration(UserRegistrationRequest request){
        checkUserAlreadyExistOrNot(request.getPin());
        Users user = new Users(
                request.getName(),
                request.getSurname(),
                request.getPin()
        );
        return converter.convert(repository.save(user));
    }

    public List<UserDto> getAllUsers(){
        return converter.convert(repository.findAll());
    }

    private void checkUserAlreadyExistOrNot(String pin){
        Optional<Users> user = repository.findByPin(pin);
        user.ifPresent(user1 -> {throw new UserAlreadyExistException("User Already Exist");});
    }

}
