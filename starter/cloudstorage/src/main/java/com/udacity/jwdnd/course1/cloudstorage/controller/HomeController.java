package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.NotesService;
import com.udacity.jwdnd.course1.cloudstorage.services.SignUpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    private SignUpService signUpService ;
    private NotesService notesService ;
    private CredentialService credentialService ;
    private FileService fileService ;

    public HomeController(SignUpService signUpService, NotesService notesService, CredentialService credentialService, FileService fileService) {
        this.signUpService = signUpService;
        this.notesService = notesService;
        this.credentialService = credentialService;
        this.fileService = fileService;
    }

    @GetMapping()
    public String getData(Model model){
        model.addAttribute(notesService.getNotes(signUpService.getId()));
        model.addAttribute(credentialService.getCredentialList(signUpService.getId()));
        // TODO add file list
        return "home";

    }
}
