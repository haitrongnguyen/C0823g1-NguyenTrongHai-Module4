package com.example.demo1;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller

public class Controller {
    @GetMapping("/")
    public String abc(){
        return "/abc";
    }

}
