package ru.safronova.skills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.safronova.skills.entity.Skill;
import ru.safronova.skills.repository.SkillRepository;
import ru.safronova.skills.service.SkillService;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/skills")
public class SkillController {
    private SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService){
        this.skillService = skillService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Skill skill){
        return ResponseEntity.ok(skillService.save(skill));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        Optional<Skill> curSkill = skillService.findById(id);
        return Objects.isNull(curSkill)
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(curSkill);
    }

    @GetMapping
    public  ResponseEntity findAll(){
        return ResponseEntity.ok(skillService.findAll());
    }

    @GetMapping("/by/{title}")
    public ResponseEntity findByTitle(@PathVariable String title){
        Skill curSkill = skillService.findByTitle(title);
        return Objects.isNull(curSkill)
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(curSkill);
    }
}
