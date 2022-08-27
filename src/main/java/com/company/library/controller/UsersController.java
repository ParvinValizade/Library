package com.company.library.controller;

import com.company.library.dto.UserDto;
import com.company.library.dto.request.UserRegistrationRequest;
import com.company.library.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("userRegistration")
    @Operation(summary = "User Registration", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<UserDto> userRegistration(@RequestBody UserRegistrationRequest request){
        return ResponseEntity.ok(usersService.userRegistration(request));
    }

    @GetMapping("getAllUsers")
    @Operation(summary = "Show All Users", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(usersService.getAllUsers());
    }

}
