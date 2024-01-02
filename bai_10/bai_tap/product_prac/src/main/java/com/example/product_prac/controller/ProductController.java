package com.example.product_prac.controller;

import com.example.product_prac.model.Cart;
import com.example.product_prac.model.Product;
import com.example.product_prac.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }
    @GetMapping()
//    public String listProduct(Model model){
//        List<Product> products = productService.findAll();
//        model.addAttribute("products",products);
//        return "home";
//    }
    public String listProduct(@PageableDefault(value = 4) Pageable pageable,
                              Model model){
        Page<Product> products = productService.findAllPage(pageable);
        model.addAttribute("products",products);
        return "home";
     }
    @GetMapping("/page")
    public String list(@PageableDefault(value = 2) Pageable pageable,
                       Model model){
        Page<Product> products = productService.findAllPage(pageable);
        model.addAttribute("products",products);
        return "page";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("product",new Product());
        return "add";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute("product") Product product,
                      Model model){
        productService.save(product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/addToCart")
    public String addToCart(@PathVariable("id") Long id,
                            @SessionAttribute("cart") Cart cart){
        Optional<Product> product = productService.findById(id);
        if (product.isEmpty()){
            return "error";
        }
        cart.addProduct(product.get());
        System.out.println(product);
        System.out.println(setupCart().getProducts().size());
        return "redirect:/shopping-cart";
    }
    @GetMapping("/{id}/decrease")
    public String decrease(@PathVariable Long id,
                           @SessionAttribute("cart") Cart cart,
                           Model model){
        Optional<Product> product = productService.findById(id);
        cart.decrease(product.get());
        return "redirect:/shopping-cart";
    }
    @GetMapping("/{id}/increase")
    public String increase(@PathVariable Long id,
                           @SessionAttribute("cart") Cart cart){
        Optional<Product> product = productService.findById(id);
        cart.increase(product.get());
        return "redirect:/shopping-cart";
    }
    @GetMapping("/{id}/edit")
    public String update(@PathVariable Long id,
                         Model model){
        Optional<Product> product = productService.findById(id);
        model.addAttribute("product",product.get());
        return "add";
    }
    @PostMapping("/{id}/edit")
    public String update(@ModelAttribute("product") Product product){
        productService.save(product);
        return "redirect:/product";
    }
    @PostMapping("/delete")
    public String remove(@RequestParam("idDelete") Long id){
        productService.delete(id);
        return "redirect:/product";
    }

}
