package ru.safronova.skills.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.safronova.skills.entity.Language;
import ru.safronova.skills.entity.Programmer;

import java.util.Arrays;
import java.util.List;

@Controller
public class WebController {
    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("user",
                new Programmer(1L, "Elena",
                        Arrays.asList(
                                new Language(1L, "Java", null),
                                new Language(2L, "Python", null)
                        ), null));

        return "index";
    }

    @GetMapping("/create_developer")
    public String developer(){
        return "developer";
    }

    @GetMapping("/create_language")
    public String language(){
        return "language";
    }

    @GetMapping("/vacancies/front")
    public String vacancies(){
        return "vacanciesFront";
    }

    @GetMapping("/vacancies/back")
    public String vacanciesBack(){return  "vacanciesBack";}
}
