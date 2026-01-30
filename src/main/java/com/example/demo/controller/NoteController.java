package com.example.demo.controller;


import com.example.demo.dto.NoteResponse;
import com.example.demo.dto.NotesCreateRequest;
import com.example.demo.service.NotesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final NotesService service;

    public NoteController(NotesService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<NoteResponse>>  getAllNotes(){
        List<NoteResponse> notas = service.findall();

        return ResponseEntity.ok(notas);
    }

    @PostMapping
    public ResponseEntity<NoteResponse> createNote(@RequestBody @Valid NotesCreateRequest dto){

        NoteResponse newNote = service.createNote(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(newNote);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteResponse> listById(@PathVariable Long id){
        NoteResponse noteId = service.listById(id);

        return ResponseEntity.ok(noteId);
    }
}
