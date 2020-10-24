package ru.safronova.skills.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;

@Table("programmers")
@AllArgsConstructor
@ToString
public class Programmer {
    @Id
    @PrimaryKeyColumn(
            name = "id",
            ordinal = 2,
            type = PrimaryKeyType.PARTITIONED,
            ordering = Ordering.DESCENDING
    )
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    // указываем, что данные объекты являеются User Data Type (UDP) и хранится будут в табл languages
    @CassandraType(type = CassandraType.Name.LIST, typeArguments = {CassandraType.Name.UDT}, userTypeName = "languages")
    @Getter
    @Setter
    private List<Language> languageList;

    @CassandraType(type = CassandraType.Name.LIST, typeArguments = {CassandraType.Name.UDT}, userTypeName = "skills")
    @Getter
    @Setter
    private List<Skill> skillList;
}
