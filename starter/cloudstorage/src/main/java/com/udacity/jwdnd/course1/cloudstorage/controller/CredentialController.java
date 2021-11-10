package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.CredentialData;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.SignUpService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;
@Controller
@RequestMapping("/credentials")
public class CredentialController{
    private SignUpService userService ;
    private  CredentialService credentialService ;

    public CredentialController(SignUpService userService, CredentialService credentialService) {
        this.userService = userService;
        this.credentialService = credentialService;
    }

    @GetMapping
    public String getCredentials(Model model){
        model.addAttribute("credentials",credentialService.getCredentialList(userService.getId()));
        return "fragments/credential-list";
    }


    @PostMapping
    public String postCredential(Model model,@ModelAttribute("credentialData")CredentialData credentialData, RedirectAttributes redirectAttributes){
        credentialData.setUserId(userService.getId());
        credentialService.createCredential(credentialData);
        model.addAttribute(credentialService.getCredentialList(userService.getId()));
        return "redirect:/home";
    }


}

