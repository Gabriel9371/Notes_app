package com.example.demo.controller;


import com.example.demo.dto.UserCreateRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        List<UserResponse> allUsers = service.listOfAllUsers();

        return ResponseEntity.status(HttpStatus.OK).body(allUsers);
    }

    @PostMapping
    public ResponseEntity<UserResponse> createNewUser(@RequestBody @Valid UserCreateRequest dto){
        UserResponse newUser = service.createUser(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id){
        UserResponse user = service.listUserById(id);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
