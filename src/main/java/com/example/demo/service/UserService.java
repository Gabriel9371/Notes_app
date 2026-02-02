package com.example.demo.service;


import com.example.demo.dto.UserCreateRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.exception.EmailAlreadyExistException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserMapper userMapper;

    public UserService(UserRepository repository, UserMapper userMapper) {
        this.repository = repository;
        this.userMapper = userMapper;
    }

    public List<UserResponse> listOfAllUsers(){
        List<User> allUsers = repository.findAll();
        List<UserResponse> toListAllUsers = userMapper.toResponseList(allUsers);

        return toListAllUsers;
    }

    public UserResponse createUser(UserCreateRequest dto){
        User toEntityUser = userMapper.toEntity(dto);
        if(repository.existsByEmail(dto.getEmail())){
            throw new EmailAlreadyExistException();
        }
        User saveUser = repository.save(toEntityUser);

        return userMapper.toResponse(saveUser);
    }

    public UserResponse listUserById(Long id){
        User user = repository.findById(id).orElseThrow(
                () -> new UserNotFoundException(id)
        );

        return userMapper.toResponse(user);
    }


    @Transactional
    public void deletUser(Long id){
        User user = repository.findById(id).orElseThrow(
                () -> new UserNotFoundException(id)
        );

        repository.delete(user);
    }

    public UserResponse uptadteUser(Long id, UserUpdateRequest dto){
        User user = repository.findById(id).orElseThrow(
                () -> new UserNotFoundException(id)
        );

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        repository.save(user);

        return userMapper.toResponse(user);


    }
}
