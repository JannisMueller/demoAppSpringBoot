package com.example.demo.controllers;

import com.example.demo.dtos.PersonDto;
import com.example.demo.dtos.PersonLastName;
import com.example.demo.mappers.PersonMapper;
import com.example.demo.repository.PersonRepository;
import com.example.demo.services.PersonService;
import com.example.demo.services.Service;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public class TestService implements Service {

    @Override
    public List<PersonDto> getAllPersons() {
        return null;
    }

    @Override
    public Optional<PersonDto> getOne(Long id) {
        if(id == 1)
            return Optional.of(new PersonDto(1,"Test","Test"));
        return Optional.empty();
    }


    @Override
    public PersonDto createPerson(PersonDto person) {
        return null;
    }

    @Override
    public void deleteOne(Long id) {

    }

    @Override
    public PersonDto replace(PersonDto personDto, long id) {
        return null;
    }

    @Override
    public PersonDto update(Long id, PersonLastName personLastName) {
        return null;
    }
}
