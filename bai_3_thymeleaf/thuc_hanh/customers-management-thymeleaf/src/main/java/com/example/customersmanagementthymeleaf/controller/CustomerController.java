package com.example.customersmanagementthymeleaf.controller;

import com.example.customersmanagementthymeleaf.model.Customer;
import com.example.customersmanagementthymeleaf.service.CustomerService;
import com.example.customersmanagementthymeleaf.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final ICustomerService customerService = new CustomerService();
    @GetMapping
    public String showList(Model model){
        List<Customer> customerList = customerService.getAll();
        model.addAttribute("customers",customerList);
        return "home";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer",new Customer());
        return "create";
    }
    @PostMapping("/save")
    public String save(Customer customer, RedirectAttributes redirectAttributes){
        customer.setId((int) (Math.random()*10000));
        customerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("success","Thêm mới thành công");
        return "redirect:/customers";
    }
    @GetMapping("/{id}/edit")
    public String update(Model model, @PathVariable int id){
        Customer customer =  customerService.findCustomerById(id);
        model.addAttribute("customer",customer);
        return "update";
    }
    @PostMapping("/update")
    public String update(Customer customer, RedirectAttributes redirectAttributes){
        customerService.updateCustomer(customer);
        redirectAttributes.addFlashAttribute("success","Chỉnh sửa thông tin khách hàng"+customer.getName()+" thành công!");
        return "redirect:/customers";
    }
    @GetMapping("/{id}/delete")
    public String delete(Model model, @PathVariable int id){
        Customer customer = customerService.findCustomerById(id);
        model.addAttribute("customer",customer);
        return "delete";
    }
    @PostMapping("/delete")
    public String delete(Customer customer,RedirectAttributes redirectAttributes){
        customerService.removeCustomer(customer);
        redirectAttributes.addFlashAttribute("success","Xóa khách hàng "+customer.getName()+" thành công!");;
        return "redirect:/customers";
    }

    @GetMapping("/{id}/detail")
    public String showDetail(@PathVariable int id, Model model){
        Customer customer = customerService.findCustomerById(id);
        model.addAttribute("customer",customer);
        return "detail";
    }
}
