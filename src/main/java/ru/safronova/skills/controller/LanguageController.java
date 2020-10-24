package ru.safronova.skills.controller;

import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.safronova.skills.entity.Language;
import ru.safronova.skills.service.LanguageService;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/languages")
public class LanguageController {
    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService){
        this.languageService = languageService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Language language){
        return ResponseEntity.ok(languageService.save(language));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        Optional<Language> curLang = languageService.findById(id);
        return Objects.isNull(curLang)
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(curLang);
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(languageService.findAll());
    }
}
