package com.example.customerprovince.controller;

import com.example.customerprovince.model.Customer;
import com.example.customerprovince.model.Province;
import com.example.customerprovince.service.ICustomerService;
import com.example.customerprovince.service.IProvinceService;
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
    @Autowired
    private IProvinceService provinceService;
    @ModelAttribute("provinces")
    public List<Province> listProvince(){
        return provinceService.findAll();
    }
    @GetMapping
    public String showList(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers",customers);
        return "/home";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer",new Customer());
        return "/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Customer customer,
                         RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Successfully!");
        return "redirect:/customers";
    }
}
