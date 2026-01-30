package com.example.demo.dto;

import java.util.List;

public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private List<NoteResponse> notas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<NoteResponse> getNotas() {
        return notas;
    }

    public void setNotas(List<NoteResponse> notas) {
        this.notas = notas;
    }
}
