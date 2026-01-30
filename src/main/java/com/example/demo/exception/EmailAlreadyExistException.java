package com.example.demo.exception;

public class EmailAlreadyExistException extends RuntimeException {
    public EmailAlreadyExistException() {
        super("Email ja esta em uso!");
    }
}
