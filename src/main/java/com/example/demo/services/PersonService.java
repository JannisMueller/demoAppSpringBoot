package com.example.demo.services;

import com.example.demo.dtos.PersonDto;
import com.example.demo.mappers.PersonMapper;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonMapper personMapper;
    private PersonRepository personRepository;

    public PersonService(PersonMapper personMapper, PersonRepository personRepository) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    public List<PersonDto> getAllPersons() {
        return personMapper.mapp(personRepository.findAll());    }

    public Optional <PersonDto> getOne(Long id) {
        return personMapper.mapp(personRepository.findById(id));
    }

    public PersonDto createPerson(PersonDto person) {
        if(person.getFirstName().isBlank())
            throw new RuntimeException();
        return personMapper.mapp(personRepository.save(personMapper.mapp(person)));

    }

    public void deleteOne(Long id) {
        personRepository.deleteById(id);
    }


}
