package com.example.springbootandrestfullandtomcat.dao.person;

import com.example.springbootandrestfullandtomcat.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id,person);
    }
    default int insertPerson2(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id,person);
    }
    List<Person> ShowData();

    Optional<Person> selectNameById(UUID id );
    Optional<Person> getNameByName(String name);

    Boolean deleteByID(UUID id);
    Boolean updateByID(UUID id, Person person);
}
