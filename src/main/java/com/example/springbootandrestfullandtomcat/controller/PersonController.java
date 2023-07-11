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

    @RequestMapping(value="/addPerson", method = RequestMethod.POST)
    public List<Person> addPerson(@RequestBody Person person){
       personService.addPersson(person);
       return  personService.ShowAllData();
    }

    @RequestMapping(value = "/getPersonByID/{id}",method = RequestMethod.GET)
//    @GetMapping(path = "{id}")
    public Person getPersonByID(@PathVariable("id") UUID id){
         return personService.selectNameByIdSRV(id)
         .orElse(null)        ;
    }

    @GetMapping(path = "{name}")
    public Person getPersonByName(@PathVariable("name") String name){
        return personService.getPerson(name)
                .orElse(null);
    }
}
