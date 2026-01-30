package com.example.demo.dto.error;


import java.time.LocalDateTime;

public class ApiErroDto {
    private int status;
    private String error;
    private String message;
    private LocalDateTime createdAt;

    public ApiErroDto(int status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.createdAt = LocalDateTime.now();

    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
