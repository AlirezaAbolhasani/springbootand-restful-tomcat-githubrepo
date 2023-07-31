package com.example.springbootandrestfullandtomcat.dao.person;

import com.example.springbootandrestfullandtomcat.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Override
    public Optional<Person> selectNameById(UUID id) {
        return DB.stream()
                .filter(Person -> Person.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Person> getNameByName(String name) {
        return DB.stream()
                .filter(Person -> Person.getName().equals(name))
                .findFirst();
    }
    @Override
    public Boolean deleteByID(UUID id) {
        Optional<Person> person = selectNameById(id);
        if(person.isEmpty()){
            return false;
        }else{
            DB.remove(id);
            return true;
        }

    }
    @Override
    public Boolean updateByID(UUID id, Person person) {
        return selectNameById(id)
                .map(p-> {
                    int indexOfpersonToUpdate = DB.indexOf(p);
                    if(indexOfpersonToUpdate >= 0){
                        person.setId(id);
                        DB.set(indexOfpersonToUpdate, person);
                        return true;
                    }
                    return false;
                })
                .orElse(false);
    }

}
