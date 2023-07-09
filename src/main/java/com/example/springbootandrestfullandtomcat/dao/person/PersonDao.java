package com.example.springbootandrestfullandtomcat.dao.person;

import com.example.springbootandrestfullandtomcat.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id,person);
    }

    List<Person> ShowData();

}
