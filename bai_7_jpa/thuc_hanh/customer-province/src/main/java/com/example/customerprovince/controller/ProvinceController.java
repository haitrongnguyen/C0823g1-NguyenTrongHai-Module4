package com.example.customerprovince.controller;

import com.example.customerprovince.model.Province;
import com.example.customerprovince.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;
    @GetMapping
    public String showList(Model model){
        List<Province> provinces = provinceService.findAll();
        model.addAttribute("provinces",provinces);
        return "/province/home";
    }
}
