package ru.safronova.skills.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.safronova.skills.entity.Question;

@Repository
public interface QuestionRepository extends CassandraRepository<Question, Long> {

}
