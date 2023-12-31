package com.example.validateuser.controller;

import com.example.validateuser.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public String showForm(Model model){
        model.addAttribute("user",new User());
        return "index";
    }
    @PostMapping("/validate")
    public String validate(@Validated @ModelAttribute User user,
                           BindingResult bindingResult,Model model){
        if (bindingResult.hasFieldErrors()){
            return "index";
        }else {
        model.addAttribute("user",user);
            return "result";
        }
    }
}
