package com.example.jpablog.controller;

import com.example.jpablog.model.Category;
import com.example.jpablog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping
    public String showList(Model model){
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categories",categoryList);
        return "/category/home";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("category",new Category());
        return "/category/create";
    }
}
