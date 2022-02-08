package com.learning.personcrud.service;

import java.util.List;

import com.learning.personcrud.model.Person;
import com.learning.personcrud.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;
    
    public String savePerson(Person person){
        personRepository.save(person);
        return "Person saved successfully!";
    }

    public List<Person> findAllPersons(){
        return personRepository.findAll();
    }

    public Person findPersonById(Long personId){
        return personRepository.findById(personId)
            .orElseThrow(() -> new IllegalStateException("Person with Id: " + personId + "not found."));
    }

}
