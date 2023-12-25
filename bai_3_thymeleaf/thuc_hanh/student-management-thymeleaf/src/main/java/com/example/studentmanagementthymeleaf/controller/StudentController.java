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
    @GetMapping("/{id}/edit")
    public String showFormEdit(@PathVariable int id,Model model){
        Student student = studentService.findStudentById(id);
        model.addAttribute("student",student);
        return "update";
    }
    @PostMapping("/{id}/eit")
    public  String edit(@PathVariable int id,@ModelAttribute Student student){
        Student student1 = studentService.findStudentById(id);
        studentService.update(id,student1);
        return "redirect:/students";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("student",new Student());
        return "create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Student student){
        
        return "create";
    }

}
