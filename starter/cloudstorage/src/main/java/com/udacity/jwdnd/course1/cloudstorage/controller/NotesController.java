package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.CredentialData;
import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.NotesService;
import com.udacity.jwdnd.course1.cloudstorage.services.SignUpService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/notes")
public class NotesController {

    private NotesService notesService;
    private SignUpService userService ;

    public NotesController(NotesService notesService, SignUpService userService) {
        this.notesService = notesService;
        this.userService = userService;
    }

    @GetMapping
    public String getNotes(Model model){
        model.addAttribute(notesService.getNotes(userService.getId()));
        return "fragments/notes-list";
    }

    @PostMapping
    public String postNotes(@ModelAttribute("note") Notes note, Model model, RedirectAttributes redirectAttributes){
        note.setUserId(userService.getId());
        notesService.createNotes(note);
        model.addAttribute(notesService.getNotes(userService.getId()));
        return "redirect:/home";
    }

}
