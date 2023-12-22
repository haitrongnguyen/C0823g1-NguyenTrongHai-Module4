package com.example.mailboxthymeleaf.controller;

import com.example.mailboxthymeleaf.model.MailBox;
import com.example.mailboxthymeleaf.service.IMailBoxService;
import com.example.mailboxthymeleaf.service.MailBoxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mailbox")
public class MailBoxController {
    private final IMailBoxService mailBoxService = new MailBoxService();
//    kiểm tra thông tin sau khi setting
    @GetMapping("/home")
    public String showMailBox(Model model){
        MailBox mailBox = mailBoxService.getMailBox();
        model.addAttribute("mailBox",mailBox);
        return "home";
    }
    @GetMapping("")
    public String update(Model model){
        List<String> language = mailBoxService.getLanguage();
        List<Integer> pageSize = mailBoxService.getPageSize();
        model.addAttribute("languages",language);
        model.addAttribute("pageSize",pageSize);
        MailBox mailBox = mailBoxService.getMailBox();
        model.addAttribute("mailBox",mailBox);
        return "update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute MailBox mailBox){
        MailBox mailBox1 = mailBoxService.getMailBox();
        mailBox1.setLanguage(mailBox.getLanguage());
        mailBox1.setPageSize(mailBox.getPageSize());
        mailBox1.setSpamsFilter(mailBox.isSpamsFilter());
        mailBox1.setSignature(mailBox.getSignature());
        return "redirect:/mailbox";
    }
}
