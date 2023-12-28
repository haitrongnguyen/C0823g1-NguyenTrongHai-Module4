package com.example.jpablog.controller;

import com.example.jpablog.model.Blog;
import com.example.jpablog.model.Category;
import com.example.jpablog.service.IBlogService;
import com.example.jpablog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @ModelAttribute("categories")
    public Iterable<Category> listCategory(){
        return categoryService.findAll();
    }
    @GetMapping
    public String showList(Model model){
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs",blogs);
        model.addAttribute("df", DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy"));
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
        blog.setTime(LocalDateTime.now());
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message","Create blog successfully");
        return "redirect:/blogs";
    }
    @PostMapping("/delete")
    public String remove(@RequestParam("idDelete") Long id){
        Blog blog = blogService.findById(id);
        blogService.delete(blog);
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
        blog.setTime(LocalDateTime.now());
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message","Update blog successfully!");
        return "redirect:/blogs";
    }
    @GetMapping("/findAll")
    public String findAll(Model model, @PageableDefault(value = 5)Pageable pageable){
        Page<Blog> blogs = blogService.findAllByOrderByTime(pageable);
        model.addAttribute("df", DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy"));
        model.addAttribute("blogs",blogs);
        return "abc";
    }
    @PostMapping("/search")
    public String search(Model model, @PageableDefault(value = 5)Pageable pageable,
                          @RequestParam("name-search") String name){
        Page<Blog> blogs = blogService.searchBlogByNameContains(pageable,name);
        model.addAttribute("df", DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy"));
        model.addAttribute("blogs",blogs);
        return "abc";
    }
    @PostMapping("/search_category")
    public String searchCategory(Model model, @PageableDefault(value = 5)Pageable pageable,
                         @RequestParam("category-search") Long name){
        Page<Blog> blogs = blogService.searchBlogByCategory_Id(pageable,name);
        model.addAttribute("df", DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy"));
        model.addAttribute("blogs",blogs);
        return "abc";
    }
}
