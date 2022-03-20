package com.learning.personcrud.service;

import com.learning.personcrud.model.Person;

import java.util.Collection;

public interface PersonService {

    Person createPerson(Person person);
    Collection<Person> listAllPersons(int limit);
    Person getPerson(Long id);
    //Person updatePerson(Person updatedPerson);
    Boolean deletePersonById(Long personId);

}
