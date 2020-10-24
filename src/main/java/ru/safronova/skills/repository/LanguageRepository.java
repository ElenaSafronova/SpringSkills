package ru.safronova.skills.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.safronova.skills.entity.Language;

@Repository
public interface LanguageRepository extends CassandraRepository<Language, Long> {
}
