package com.learning.personcrud.service.implementation;

import java.util.Collection;
import java.util.List;

import com.learning.personcrud.model.Person;
import com.learning.personcrud.repository.PersonRepository;

import com.learning.personcrud.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    @Autowired
    private final PersonRepository personRepository;

    @Override
    public Person createPerson(Person person){
        log.info("New person saved: {}");
        return personRepository.save(person);
    }

    @Override
    public Collection<Person> listAllPersons(int limit){
        log.info("Listing all persons...");
        return personRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Person getPerson(Long personId){
        log.info("Getting person with ID: {}");
        return personRepository.findById(personId).get();
    }

    /*
    public Person updatePerson(Person updatedPerson) {
    	log.info("Updating person with ID: {}");
    	return personRepository.save(updatedPerson);
    }
    */
    
    public Boolean deletePersonById(Long personId) {
        log.info("Deleting person with ID: {}");
        personRepository.deleteById(personId);
    	return Boolean.TRUE;
    }

}
