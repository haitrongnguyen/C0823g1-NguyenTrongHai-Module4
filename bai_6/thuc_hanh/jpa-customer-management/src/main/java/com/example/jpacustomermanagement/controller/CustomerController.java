package com.example.jpacustomermanagement.controller;

import com.example.jpacustomermanagement.model.Customer;
import com.example.jpacustomermanagement.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping
    public String findAll(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers",customers);
        return "home";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer",new Customer());
        return "create";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute("customer") Customer customer,
                       RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","Create customer successfully!");
        customerService.save(customer);
        return "redirect:/customers";
    }
}
