package com.company.library.service;

import com.company.library.dto.BooksOfUserDto;
import com.company.library.dto.converter.BooksOfUserDtoConverter;
import com.company.library.dto.request.AssignBookToUserRequest;
import com.company.library.dto.request.ReturnedBooksRegistrationRequest;
import com.company.library.exception.AnyRowNotFoundException;
import com.company.library.model.Book;
import com.company.library.model.BooksOfUser;
import com.company.library.repository.BooksOfUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BooksOfUserService {
    private final BooksOfUserRepository repository;
    private final BooksOfUserDtoConverter converter;

    private final UsersService usersService;
    private final BookService bookService;

    public BooksOfUserService(BooksOfUserRepository repository, BooksOfUserDtoConverter converter, UsersService usersService, BookService bookService) {
        this.repository = repository;
        this.converter = converter;
        this.usersService = usersService;
        this.bookService = bookService;
    }

    public BooksOfUserDto assignBookToUser(AssignBookToUserRequest request){
        usersService.findUserById(request.getUserId());
        bookService.findBookByIdAndCheckStockEqualsZeroOrNot(request.getBookId());
        BooksOfUser booksOfUser = new BooksOfUser(
                request.getUserId(),
                request.getBookId(),
                LocalDate.now()
        );
        return converter.convert(repository.save(booksOfUser));
    }

    public List<BooksOfUserDto> returnedBooksRegistration(ReturnedBooksRegistrationRequest request){
        usersService.findUserById(request.getUserId());
        Book book = bookService.findBookById(request.getBookId());
        List<BooksOfUser> booksOfUserList = checkAnyDataExistOrNot(request.getUserId(),request.getBookId());
        booksOfUserList.forEach(booksOfUser ->
        {booksOfUser.setDateOfReturnFromUser(LocalDate.now());
         bookService.increaseStock(book);
        repository.save(booksOfUser);});
        return converter.convert(booksOfUserList);

    }

    public Integer countOfGivenBooks(LocalDate date){
        return repository.countByDateOfGivingToUserEquals(date);
    }

    public Integer countOfReturnedBooks(LocalDate date){
        return repository.countByDateOfReturnFromUserEquals(date);
    }

    private List<BooksOfUser> checkAnyDataExistOrNot(Long userId, Long bookId){
        List<BooksOfUser> booksOfUserList = repository.findByUserIdAndBookId(userId,bookId);
        if (booksOfUserList.isEmpty()){
            throw new AnyRowNotFoundException("Any information not found by following userId: "
                    +userId +" and bookId: "+bookId);
        } else {
            return booksOfUserList;
        }
    }
}
