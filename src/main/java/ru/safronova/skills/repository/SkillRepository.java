package ru.safronova.skills.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;
import ru.safronova.skills.entity.Skill;

import java.util.Optional;

@Repository
public interface SkillRepository extends CassandraRepository<Skill, Long> {

    @Query("select * from test.skills where title = ?0 ALLOW FILTERING") // where title = first argument
    Optional<Skill> findByTitle(String title);
}
