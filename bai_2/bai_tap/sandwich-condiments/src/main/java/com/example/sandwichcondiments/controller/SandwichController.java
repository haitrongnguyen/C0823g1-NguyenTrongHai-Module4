package com.example.sandwichcondiments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping(value = "/condiment")
    public String showSelect(){
        return "condiment";
    }

    @PostMapping(value = "/condiment")
    public String showCondiment(Model model, @RequestParam("condiment") String[]condiment){
        model.addAttribute("condiment",condiment);
        return "condiment";
    }
}
