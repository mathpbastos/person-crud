package com.learning.personcrud.controller;

import java.util.List;

import com.learning.personcrud.model.Person;
import com.learning.personcrud.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    private PersonService personService;
    
    @PostMapping(path = "/new")
    public String createNewPerson(@RequestBody(required = true) Person person){
        return personService.savePerson(person);
    }

    @GetMapping("/all")
    public List<Person> listAllPersons(){
       return personService.findAllPersons();
    }

    @GetMapping("/{personId}")
    public Person getPersonById(
        @PathVariable(
            required = true,
            name = "personId"
        )
        Long personId
    ){
        return personService.findPersonById(personId);
    }

}
