package com.example.songvalidate.controller;

import com.example.songvalidate.model.Song;
import com.example.songvalidate.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping
    public String showList(Model model) {
        List<Song> songs = songService.findAll();
        model.addAttribute("songs", songs);
        return "home";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute("song") Song song,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        System.out.println("oki");

        System.out.println(song.getId());
        System.out.println(song.getName());
        System.out.println(song.getSinger());
        System.out.println(song.getCategory());
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("song",song);
            return "create";
        }
            songService.save(song);
            redirectAttributes.addFlashAttribute("message","Create Successfully!!");
            return "redirect:/song";

    }
}
