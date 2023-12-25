package com.example.ormproductmanagement.controller;

import com.example.ormproductmanagement.model.Product;
import com.example.ormproductmanagement.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping
    public String showList(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "home";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/create")
    public String save(Product product,RedirectAttributes redirect){
        productService.save(product);
        redirect.addFlashAttribute("message","Create product successfully!");
        return "redirect:/products";
    }
    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable int id,
                                 Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Product product,RedirectAttributes redirect){
        productService.save(product);
        redirect.addFlashAttribute("message","Update product successfully!");
        return "redirect:/products";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("idDelete") int id, RedirectAttributes model){
        productService.remove(id);
        model.addFlashAttribute("message","Removed product successfully!");
        return "redirect:/products";
    }
    @GetMapping("/search")
    public String showFormSearch(){
        return "search";
    }
    @PostMapping("/search")
    public String search(@RequestParam("name") String name,Model model){
        List<Product> products = productService.findByName(name);
        model.addAttribute("products",products);
        return "search";
    }
//    @GetMapping("/sort")
//    public String sort(RedirectAttributes redirectAttributes){
//        List<Product> products = productService.sort();
//        redirectAttributes.addFlashAttribute("products",products);
////        model.addAttribute("products",products);
//        return "redirect:/products";
//    }
@GetMapping("/sort")
    public String sort(Model model){
        List<Product> products = productService.sort();
//        redirectAttributes.addFlashAttribute("products",products);
        model.addAttribute("products",products);
        return "home";
    }
    @GetMapping("/sortByName")
    public String sortByName(Model model){
        List<Product> products = productService.sortByName();
        model.addAttribute("products",products);
        return "home";
    }
}
