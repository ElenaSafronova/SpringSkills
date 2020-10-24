package ru.safronova.skills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Service;
import ru.safronova.skills.entity.Programmer;
import ru.safronova.skills.repository.ProgrammerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProgrammerService {
    private ProgrammerRepository programmerRepository;

    @Autowired
    public ProgrammerService(ProgrammerRepository programmerRepository) {
        this.programmerRepository = programmerRepository;
    }

    public Programmer save(Programmer programmer){
        return programmerRepository.save(programmer);
    }

    public Optional<Programmer> findById(Long id){
        return programmerRepository.findById(id);
    }

    public List<Programmer> findAll(){
        return programmerRepository.findAll();
    }
}
