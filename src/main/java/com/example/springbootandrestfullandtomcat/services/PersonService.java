package com.example.springbootandrestfullandtomcat.services;

import com.example.springbootandrestfullandtomcat.dao.person.PersonDao;
import com.example.springbootandrestfullandtomcat.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public  Optional<Person> selectNameByIdSRV(UUID id){
        return personDao.selectNameById(id);
    }
    public  Optional<Person> getPerson(String name){
        return personDao.getNameByName(name);
    }
    public boolean deleteAnItemByUseId(UUID id){
        return personDao.deleteByID(id);
    }
    public boolean updatePerson(UUID id, Person person){
        Boolean updateByID = personDao.updateByID(id,person);
        return  updateByID;
    }

}
