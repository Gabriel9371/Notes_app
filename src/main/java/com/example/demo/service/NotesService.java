package com.example.demo.service;


import com.example.demo.dto.NoteResponse;
import com.example.demo.dto.NotesCreateRequest;
import com.example.demo.exception.NoteNotFoundIdException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.mapper.NoteMapper;
import com.example.demo.model.Note;
import com.example.demo.model.User;
import com.example.demo.repository.NoteRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotesService {
    private final UserRepository userRepository;
    private final NoteRepository noteRepository;
    private final NoteMapper mapper;

    public NotesService(UserRepository userRepository, NoteRepository noteRepository, NoteMapper mapper) {
        this.userRepository = userRepository;
        this.noteRepository = noteRepository;
        this.mapper = mapper;
    }

    public List<NoteResponse> findall(){
        List<Note> allNotes = noteRepository.findAll();
        List<NoteResponse> toListAllNotes = mapper.toResponseList(allNotes);

        return toListAllNotes;
    }

    public NoteResponse createNote(NotesCreateRequest dto){
        User idUser = userRepository.findById(dto.getUserId()).orElseThrow(
                () -> new UserNotFoundException(dto.getUserId())
        );

        Note newNote = mapper.toEntity(dto);
        newNote.setUser(idUser);
        Note saveNewNote = noteRepository.save(newNote);

        return mapper.toResponse(saveNewNote);
    }

    public NoteResponse listById(Long id){
        Note note = noteRepository.findById(id).orElseThrow(
                () -> new NoteNotFoundIdException(id)
        );

        return mapper.toResponse(note);
    }
}
