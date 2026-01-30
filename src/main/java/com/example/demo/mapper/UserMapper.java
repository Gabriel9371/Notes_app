package com.example.demo.mapper;


import com.example.demo.dto.UserCreateRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final NoteMapper mapper;

    public UserMapper(NoteMapper mapper) {
        this.mapper = mapper;
    }

    public User toEntity(UserCreateRequest dto){
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        return user;
    }

    public UserResponse toResponse(User dados){
        UserResponse response = new UserResponse();
        response.setId(dados.getId());
        response.setName(dados.getName());
        response.setEmail(dados.getEmail());
        response.setNotas(mapper.toResponseList(dados.getNotes()));

        return response;
    }

}
