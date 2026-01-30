package com.example.demo.mapper;


import com.example.demo.dto.NoteResponse;
import com.example.demo.dto.NotesCreateRequest;
import com.example.demo.model.Note;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NoteMapper {
    public Note toEntity(NotesCreateRequest dto){
        Note note = new Note();
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());

        return note;
    }

    public NoteResponse toResponse(Note note){
        NoteResponse response = new NoteResponse();

        response.setId(note.getId());
        response.setTitle(note.getTitle());
        response.setContent(note.getContent());

        if(note.getUser() != null){
            response.setUserId(note.getUser().getId());
        }


        return response;
    }

    public List<NoteResponse> toResponseList(List<Note> notas){
        return notas.stream().map(this::toResponse).toList();
    }
}
