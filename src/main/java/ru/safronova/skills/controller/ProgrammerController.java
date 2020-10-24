package ru.safronova.skills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.safronova.skills.entity.Programmer;
import ru.safronova.skills.service.ProgrammerService;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/programmers")
public class ProgrammerController {
    private ProgrammerService programmerService;

    @Autowired
    public ProgrammerController(ProgrammerService programmerService){
        this.programmerService = programmerService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Programmer programmer){
        return ResponseEntity.ok(programmerService.save(programmer));
    }

    @GetMapping("/{id}")
    public ResponseEntity findBuID(@PathVariable Long id){
        Optional<Programmer> curProgrammer = programmerService.findById(id);
        return Objects.isNull(curProgrammer)
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(curProgrammer);
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(programmerService.findAll());
    }
}
