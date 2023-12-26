package com.example.jpablog.controller;

import com.example.jpablog.model.Blog;
import com.example.jpablog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping
    public String showList(Model model){
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs",blogs);
        return "home";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute("blog") Blog blog,
                       RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message","Create blog successfully");
        return "redirect:/blogs";
    }
    @PostMapping("/delete")
    public String remove(@ModelAttribute Blog blog){
        blogService.remove(blog);
        return "redirect:/blogs";
    }
    @GetMapping("/{id}/detail")
    public String detail(@PathVariable Long id,
                         Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "detail";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id,Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "edit";
    }
    @PostMapping("/{id}/edit")
    public String edit(@ModelAttribute Blog blog,RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message","Update blog successfully!");
        return "redirect:/blogs";
    }
}
