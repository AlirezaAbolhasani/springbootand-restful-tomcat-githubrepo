package com.example.springbootandrestfullandtomcat.dao.person;

import com.example.springbootandrestfullandtomcat.model.Person;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("personDao") //== @Component("personDao")
public class PersonRepository implements PersonDao{

    public  static List<Person> DB =new ArrayList<>();
    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id,person.getName()));
        return 11;
    }

    @Override
    public List<Person> ShowData() {
        return DB;
    }

}
