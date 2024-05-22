package com.example.module16hw17.service;

import com.example.module16hw17.entity.Note;
import com.example.module16hw17.repository.NotesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NotesRepository notesRepository;

    @Override
    public List<Note> listAll() {
        return notesRepository.findAll();
    }
    @Override
    public Note add(Note note) {
        return notesRepository.save(note);
    }

    @Override
    public void deleteById(long id) {
        notesRepository.deleteById(id);
    }

    @Override
    public Note update(Note note) {
       Note currentNote = notesRepository.getReferenceById(note.getId());
       currentNote.setTitle(note.getTitle());
       currentNote.setContent(note.getContent());
       notesRepository.save(currentNote);
       return currentNote;
    }

    @Override
    public Note getById(long id) {
        return notesRepository.getReferenceById(id);
    }


}
