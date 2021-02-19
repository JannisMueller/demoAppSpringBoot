package com.example.demo.services;

import com.example.demo.dtos.PersonDto;
import com.example.demo.dtos.PersonLastName;

import java.util.List;
import java.util.Optional;

public interface Service {



    List<PersonDto> getAllPersons();

    Optional<PersonDto> getOne(Long id);

    PersonDto createPerson(PersonDto person);

    void deleteOne(Long id);

    PersonDto replace(PersonDto personDto, long id);

    PersonDto update(Long id, PersonLastName personLastName);
}
