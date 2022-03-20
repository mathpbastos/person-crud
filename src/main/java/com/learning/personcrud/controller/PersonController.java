package com.learning.personcrud.controller;

import java.time.LocalDateTime;
import java.util.Map;

import com.learning.personcrud.model.Person;
import com.learning.personcrud.model.Response;
import com.learning.personcrud.service.implementation.PersonServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    @Autowired
    private PersonServiceImpl personService;
    
    @PostMapping(path = "/save")
    public ResponseEntity<Response> savePerson(@RequestBody @Valid Person person){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("Person", personService.createPerson(person)))
                        .message("Person Saved.")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }

    @GetMapping("/list")
    public ResponseEntity<Response> getAllPersons(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("Persons", personService.listAllPersons(30)))
                        .message("Persons Listed.")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/get/{personId}")
    public ResponseEntity<Response> getPersonById(@PathVariable("personId") Long personId){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("Person", personService.getPerson(personId)))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    /*
    @PutMapping("/update/{personId}")
    public String updatePerson(
    		@PathVariable("personId") Long personId, @RequestBody Person updatedPerson){
    	return personService.updatePerson(personId, updatedPerson);
    }*/
    
    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<Response> deletePerson(@PathVariable("personId") Long personId) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("Deleted", personService.deletePersonById(personId)))
                        .message("Person deleted")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

}
