package com.example.demo.controllers;

import com.example.demo.PersonDto;
import com.example.demo.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public List<PersonDto> all() {
        return personService.getAllPersons();
    }

    @GetMapping("/person/{id}")
    public PersonDto one(@PathVariable Long id) {
        return personService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "id "  + id +" not found"));

    }

    @PostMapping("/person")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDto create (PersonDto person){

        return personService.createPerson(person);

    }
}
