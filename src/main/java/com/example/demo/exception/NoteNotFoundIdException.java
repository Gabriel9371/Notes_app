package com.example.demo.exception;

public class NoteNotFoundIdException extends RuntimeException {
    public NoteNotFoundIdException(Long id) {
        super("Nota com ID "+ id +" não encontrada");
    }
}
