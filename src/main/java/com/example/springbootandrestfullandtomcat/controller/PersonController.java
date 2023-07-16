package com.example.springbootandrestfullandtomcat.controller;

import com.example.springbootandrestfullandtomcat.model.Person;
import com.example.springbootandrestfullandtomcat.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("webkaiser")
@RestController

public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    //127.0.0.1:8080/webkaiser/addPerson
    //{	"name":"pain"}
    @RequestMapping(value="/addPerson", method = RequestMethod.POST)
    public List<Person> addPerson(@RequestBody Person person){
       personService.addPersson(person);
       return  personService.ShowAllData();
    }

    //127.0.0.1:8080/webkaiser/getPersonByID/de1fc431-6f77-44c9-bb81-f05921f1c868
    @RequestMapping(value = "/getPersonByID/{id}",method = RequestMethod.GET)
    public Person getPersonByID(@PathVariable("id") UUID uuid){
         return personService.selectNameByIdSRV(uuid)
         .orElse(null)        ;
    }
    //127.0.0.1:8080/webkaiser/Alireza
    @GetMapping(path = "{name}")
    public Person getPersonByName(@PathVariable("name") String name){
        return personService.getPerson(name)
                .orElse(null);
    }
   //127.0.0.1:8080/webkaiser/0b1b7a4a-b7cc-4759-a014-b1f923e697b0
    @DeleteMapping(path="{id}")
    public Boolean deletePersonByID(@PathVariable("id") UUID uuid){
        return personService.deleteAnItemByUseId(uuid);
    }

    //127.0.0.1:8080/webkaiser/4bf443a6-ce4b-422d-a130-943bdf26869a
    //{"name":"Test"}
    @PutMapping(path="{id}")
    public Boolean updatePersonByID(@PathVariable("id") UUID uuid , @RequestBody Person personToUpdate){
       return personService.updatePerson(uuid,personToUpdate);
    }

}
