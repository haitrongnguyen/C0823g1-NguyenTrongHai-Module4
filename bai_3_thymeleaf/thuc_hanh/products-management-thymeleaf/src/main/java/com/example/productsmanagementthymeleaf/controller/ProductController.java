package com.example.productsmanagementthymeleaf.controller;

import com.example.productsmanagementthymeleaf.model.Product;
import com.example.productsmanagementthymeleaf.service.IProductService;
import com.example.productsmanagementthymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.beans.Customizer;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService = new ProductService();
    @GetMapping
    public String showList(Model model){
        List<Product> products = productService.getAll();
        model.addAttribute("products",products);
        return "home";
    }
    @GetMapping("/{id}/edit")
    public String update(@PathVariable int id,Model model){
        Product product = productService.findProductById(id);
        model.addAttribute("product",product);
        return "update";
    }
    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes){
        productService.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("message","Chỉnh sửa thông tin sản phẩm "+product.getName()+" thành công!");
        return "redirect:/products";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id,Model model){
        Product product = productService.findProductById(id);
        model.addAttribute("product",product);
        return "delete";
    }
    @PostMapping("/delete")
    public String delete(Product product,RedirectAttributes redirectAttributes){
        productService.delete(product.getId());
        redirectAttributes.addFlashAttribute("message","Xóa sản phẩm "+product.getName()+" thành công!");
        return "redirect:/products";
    }
    @GetMapping("/{id}/detail")
    public String showDetail(@PathVariable int id,Model model){
        Product product = productService.findProductById(id);
        model.addAttribute("product",product);
        return "detail";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/create")
    public String save(Product product,RedirectAttributes redirectAttributes){
        product.setId((int) (Math.random()*1000));
        productService.save(product);
        redirectAttributes.addFlashAttribute("message","Thêm mới sản phẩm "+product.getName()+" thành công!");
        return "redirect:/products";
    }
    @GetMapping("/search")
    public String search(){
        return "search";
    }
    @PostMapping(value = "/search", produces = "text/plain; charset=UTF-8"  )
    public String search(Model model, @RequestParam String name){
        System.out.println(name);
        List<Product> products = productService.findByName(name);
        model.addAttribute("products",products);
        return "search";
    }
}
