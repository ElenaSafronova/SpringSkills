package ru.safronova.skills.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.safronova.skills.entity.Test;

@Repository
public interface TestRepository extends CassandraRepository<Test, Long> {
}
