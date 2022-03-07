package com.learning.personcrud.controller;

import java.util.List;

import com.learning.personcrud.model.Person;
import com.learning.personcrud.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/details/{personId}")
    public Person getPersonById(
        @PathVariable(
            required = true,
            name = "personId"
        )
        Long personId
    ){
        return personService.findPersonById(personId);
    }
    
    @PutMapping("/update/{personId}")
    public String updatePerson(
    		@PathVariable(
    				required = true,
    				name = "personId"
    		)
    		Long personId,
    		@RequestBody 
    		Person updatedPerson
    ){
    	return personService.updatePerson(personId, updatedPerson);
    }
    
    @DeleteMapping("/delete/{personId}")
    public String deletePerson(@PathVariable(
    			required = true,
    			name = "personId"
    		) Long personId) {
    	return personService.deletePerson(personId);
    }

}
