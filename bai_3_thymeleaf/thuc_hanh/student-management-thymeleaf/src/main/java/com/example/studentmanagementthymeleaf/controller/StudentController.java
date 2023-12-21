package com.example.studentmanagementthymeleaf.controller;

import com.example.studentmanagementthymeleaf.model.Student;
import com.example.studentmanagementthymeleaf.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping
    public String showList(Model model){
        List<Student> studentList = studentService.getAll();
        model.addAttribute("students",studentList);
        return "home";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("idEdit") int id){
        studentService.delete(id);
        return "redirect:/students";
    }
}
