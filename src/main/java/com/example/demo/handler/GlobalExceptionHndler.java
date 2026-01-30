package com.example.demo.handler;


import com.example.demo.dto.error.ApiErroDto;
import com.example.demo.exception.EmailAlreadyExistException;
import com.example.demo.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHndler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiErroDto> handlerUserNotFound(UserNotFoundException ex){
        ApiErroDto error = new ApiErroDto(
                HttpStatus.NOT_FOUND.value(),
                "USER_NOT_FOUND",
                ex.getMessage()

        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<ApiErroDto> handlerEmailAlreadyExist(EmailAlreadyExistException ex){
        ApiErroDto error  = new ApiErroDto(
          HttpStatus.CONFLICT.value(),
          "EMAIL_ALREADY_EXISTS",
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
}
