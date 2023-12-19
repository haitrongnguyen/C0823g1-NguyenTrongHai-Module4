package com.example.dictionary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    private static Map<String,String> dic = new HashMap<>();
    static {
        dic.put("what","Cái gì");
        dic.put("how","Thế nào");
        dic.put("where","Ở đâu");
        dic.put("when","Khi nào");
    }
    @GetMapping("/dic")
    public String showForm(){
        return "home-dic";
    }
    @PostMapping("/dic")
    public ModelAndView translate(@RequestParam("word") String word){
        ModelAndView modelAndView = new ModelAndView("home-dic");
        modelAndView.addObject("word",word);
        boolean checkNull = true;
        for (Map.Entry<String,String> entry: dic.entrySet()){
            if (entry.getKey().equals(word)){
                modelAndView.addObject("result",entry.getValue());
                checkNull = false;
            }
        }
        if (checkNull){
            modelAndView.addObject("result","Không tìm thấy");
        }
        return modelAndView;
    }

}
