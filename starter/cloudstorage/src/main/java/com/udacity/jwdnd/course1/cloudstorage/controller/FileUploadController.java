package com.udacity.jwdnd.course1.cloudstorage.controller;



import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.storage.StorageFileNotFoundException;
import com.udacity.jwdnd.course1.cloudstorage.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class FileUploadController {

    private FileService fileService ;

    @Autowired
    public FileUploadController(FileService fileService) {
        this.fileService = fileService ;
    }

    @GetMapping("/home/files")
    public String listUploadedFiles(Model model) throws IOException {

        return "home";
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("files") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {


        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }
}








