package com.example.validateuser.controller;

import com.example.validateuser.model.PhoneNumber;
import com.example.validateuser.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller

public class UserController {
    @GetMapping("/user")
    public String showForm(Model model){
        model.addAttribute("user",new User());
        return "index";
    }
    @PostMapping("/validateUser")
    public String checkValidate(@Validated @ModelAttribute User user,
                                BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "index";
        }
        return "result";
    }
    @GetMapping("/phone")
    public String showFormPhone(Model model){
        model.addAttribute("phoneNumber",new PhoneNumber());
        return "phone";
    }
    @PostMapping("/phone")
    public String validatePhone(@Valid @ModelAttribute PhoneNumber phoneNumber,
                                Model model,BindingResult bindingResult){
        new PhoneNumber().validate(phoneNumber,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "phone";
        }else {
            model.addAttribute("phoneNumber",phoneNumber);
            return "phone_result";
        }
    }
}
