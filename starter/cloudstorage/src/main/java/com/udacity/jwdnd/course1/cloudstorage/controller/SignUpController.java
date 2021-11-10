package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.SignUpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    private SignUpService service ;

    public SignUpController(SignUpService service) {
        this.service = service;
    }

    @GetMapping()
    public String getSignUp(){
        return "signup";
    }



    @PostMapping()
    public  String postSignUp(@ModelAttribute("user") User user, Model model){
           String signupError = null ;

           if(!service.isUsernameAvailable(user.getUsername())) signupError = "Username already exists..Please login";

           if(signupError==null){
               int rowsAdded = service.createUser(user);
               if(rowsAdded<0) signupError="There was a problem with our service, please try again later";
           }
           if(signupError==null){
               model.addAttribute("successfulSignUp",true);
           }
           else{
               model.addAttribute("signupError",signupError);
           }

        return "signup";
    }

}
