package com.example.module16hw17.service;

import com.example.module16hw17.entity.Note;

import java.util.List;
import java.util.UUID;

public interface NoteService {

    List<Note> listAll();
    Note add(Note note);
    void deleteById(long id);
    Note update(Note note);
    Note getById(long id);
}
