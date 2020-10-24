package ru.safronova.skills.service;

import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.safronova.skills.entity.Language;
import ru.safronova.skills.repository.LanguageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    private LanguageRepository languageRepository;

    @Autowired
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public Language save(Language language){
        return languageRepository.save(language);
    }

    public Optional<Language> findById(Long id){
        return languageRepository.findById(id);
    }

    public List<Language> findAll(){
        return languageRepository.findAll();
    }
}
