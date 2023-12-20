package com.example.caculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping(value = "/calculator")
    public String showCalculator(){
        return "calculator";
    }

    @PostMapping(value = "/calculator")
    public String calculator(Model model, @RequestParam("operator") String operator,
                             @RequestParam("firstNumber") int num1,
                             @RequestParam("secondNumber") int num2){
        model.addAttribute("firstNumber",num1);
        model.addAttribute("secondNumber",num2);
        switch (operator){
            case "Addition(+)":
                model.addAttribute("operator","Addition");
                model.addAttribute("result",num1+num2);
                break;
            case "Subtraction(-)":
                model.addAttribute("operator","Subtraction");

                model.addAttribute("result",num1-num2);
                break;
            case "Multiplication(*)":
                model.addAttribute("operator","Multiplication");

                model.addAttribute("result",num1*num2);
                break;
            case "Division(/)":
                if (num2==0){
                    model.addAttribute("result","Error: by Zero");
                }else {
                    model.addAttribute("operator","Division");
                    model.addAttribute("result",num1/num2);
                }
                break;
        }

        return "calculator";
    }
}
