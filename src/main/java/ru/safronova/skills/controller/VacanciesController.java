package ru.safronova.skills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.safronova.skills.entity.SearchParametersVacancy;
import ru.safronova.skills.service.VacanciesService;

@RestController
@RequestMapping("/vacancies")
public class VacanciesController {
    private final VacanciesService vacanciesService;

    @Autowired
    public VacanciesController(VacanciesService vacanciesService) {
        this.vacanciesService = vacanciesService;
    }

    @GetMapping
    public ResponseEntity getAllVacancies(){
        return ResponseEntity.ok(vacanciesService.getAllVacancies().getItems());
    }

    @PostMapping
    public ResponseEntity getAllVacancies(@RequestBody SearchParametersVacancy params){
        return ResponseEntity.ok(vacanciesService.getAllVacancies(params).getItems());
    }

    @GetMapping("/{id}")
    public  ResponseEntity getVacancyById(@PathVariable String id){
        return  ResponseEntity.ok(vacanciesService.getVacancyById(id));
    }
}
