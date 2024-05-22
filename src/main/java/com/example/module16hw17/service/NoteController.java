package com.example.module16hw17.service;

import com.example.module16hw17.entity.Note;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@RequiredArgsConstructor
@Controller
@RequestMapping("/notes")
public class NoteController {

    private final NoteServiceImpl noteService;

    @PostConstruct
    public void init() {
        System.out.println("Start");
    }

    @GetMapping("/list")
    public ModelAndView getAllNotes() {
        ModelAndView result = new ModelAndView("notes");
        result.addObject("notes", noteService.listAll());
        return result;
    }

    @PostMapping("/create")
    public String createNote(@RequestParam("title") String title, @RequestParam("content") String content) {
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        noteService.add(note);
        return "redirect:/notes/list";
    }

    @PostMapping("/save")
    public String saveNote(@RequestParam("id") long id, @RequestParam("title") String title, @RequestParam("content") String content) {
        Note note = new Note();
        note.setId(id);
        note.setTitle(title);
        note.setContent(content);
        noteService.update(note);
        return "redirect:/notes/list";
    }

    @GetMapping("/edit")
    public ModelAndView getNoteForEdit(@RequestParam("id") long id){
        ModelAndView result = new ModelAndView("edit_note");
        result.addObject("note",noteService.getById(id));
        return result;

    }

    @PostMapping("/update")
    public String editNote(@RequestParam("id") long id, @RequestParam("title") String title, @RequestParam("content") String content){
        Note note = new Note();
        note.setId(id);
        note.setTitle(title);
        note.setContent(content);
        noteService.update(note);
        return "redirect:/notes/list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") long id) {
        noteService.deleteById(id);
        return "redirect:/notes/list";
    }

}
