package com.example.demo.controllers;

import com.example.demo.dtos.PersonDto;
import com.example.demo.dtos.PersonLastName;
import com.example.demo.services.PersonService;
import com.example.demo.services.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class PersonController {

    private Service service;

    public PersonController(Service service) {
        this.service = service;
    }

    @GetMapping("/persons")
    public List<PersonDto> all() {
        return service.getAllPersons();
    }

    @GetMapping("/persons/{id}")
    public PersonDto one(@PathVariable Long id) {
        return service.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "id "  + id +" not found"));

    }

    @PostMapping("/persons")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDto create (PersonDto person){

        return service.createPerson(person);

    }

    @DeleteMapping("/persons/{id}")
    public void deleteOne(@PathVariable Long id){
        service.deleteOne(id);
    }

    @PutMapping("/persons/{id}")
    public PersonDto replace(@RequestBody PersonDto personDto, @PathVariable long id){
        return service.replace(personDto,id);

    }

    @PatchMapping("/persons/{id}")
    public PersonDto update(@RequestBody PersonLastName personLastName, @PathVariable Long id) {
        return service.update(id, personLastName);
    }
}

