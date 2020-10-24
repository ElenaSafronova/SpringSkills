package ru.safronova.skills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.safronova.skills.entity.Question;
import ru.safronova.skills.service.QuestionService;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Question question){
        return ResponseEntity.ok(questionService.save(question));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        Optional<Question> curQuestion = questionService.findById(id);
        return Objects.isNull(curQuestion) ?
                ResponseEntity.notFound().build()
                : ResponseEntity.ok(curQuestion);
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(questionService.findAll());
    }
}
