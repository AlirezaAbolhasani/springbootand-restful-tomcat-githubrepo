package com.example.springbootandrestfullandtomcat.services;

import com.example.springbootandrestfullandtomcat.dao.person.PersonDao;
import com.example.springbootandrestfullandtomcat.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    
    private PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("personDao") PersonDao personDao) {
        this.personDao = personDao;
    }


    public int addPersson(Person person){
        return  personDao.insertPerson(person);
    }

    public List<Person> ShowAllData(){
        return personDao.ShowData();
    }
}
