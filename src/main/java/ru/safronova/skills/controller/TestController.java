package ru.safronova.skills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.safronova.skills.entity.Test;
import ru.safronova.skills.service.TestService;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/tests")
public class TestController {
    private TestService testService;

    @Autowired
    public TestController(TestService testService){
        this.testService = testService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Test test){
        return ResponseEntity.ok(testService.save(test));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        Optional<Test> curTest = testService.findById(id);
        return Objects.isNull(curTest)
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(curTest);
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(testService.findAll());
    }
}
