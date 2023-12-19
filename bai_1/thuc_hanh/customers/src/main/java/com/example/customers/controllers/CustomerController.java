package com.example.customers.controllers;

import com.example.customers.model.Customer;
import com.example.customers.service.CustomerService;
import com.example.customers.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CustomerController {
//    private ICustomerService customerService = new CustomerService();
    @Autowired
    ICustomerService customerService;
    @GetMapping("/customers")
//    public String showList(Model model){
//        List<Customer> customers = customerService.getAll();
//        model.addAttribute("list",customers);
//        return "list";
//    }
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("list");
        List<Customer> customers = customerService.getAll();
        modelAndView.addObject("list",customers);
        return modelAndView;
    }

}
