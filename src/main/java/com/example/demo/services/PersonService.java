package com.example.demo.services;

import com.example.demo.dtos.PersonDto;
import com.example.demo.dtos.PersonLastName;
import com.example.demo.entities.Person;
import com.example.demo.mappers.PersonMapper;
import com.example.demo.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements com.example.demo.services.Service {

    private final PersonMapper personMapper;
    private PersonRepository personRepository;

    public PersonService(PersonMapper personMapper, PersonRepository personRepository) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    @Override
    public List<PersonDto> getAllPersons() {
        return personMapper.mapp(personRepository.findAll());    }

    @Override
    public Optional <PersonDto> getOne(Long id) {
        return personMapper.mapp(personRepository.findById(id));
    }

    @Override
    public PersonDto createPerson(PersonDto person) {
        if(person.getFirstName().isBlank())
            throw new RuntimeException();
        return personMapper.mapp(personRepository.save(personMapper.mapp(person)));

    }

    @Override
    public void deleteOne(Long id) {
        personRepository.deleteById(id);
    }


    @Override
    public PersonDto replace(PersonDto personDto, long id) {

        Optional <Person> person = personRepository.findById(id);
        if(person.isPresent()){

        Person updatedPerson = person.get();
        updatedPerson.setFirstName(personDto.getFirstName());
        updatedPerson.setLastName(personDto.getLastName());
        return personMapper.mapp(personRepository.save(updatedPerson));

    }
    else
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    @Override
    public PersonDto update(Long id, PersonLastName personLastName) {
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent())
        {
            Person updatedPerson = person.get();
            if(personLastName.lastName != null)
                updatedPerson.setLastName(personLastName.lastName);
            return personMapper.mapp(personRepository.save(updatedPerson));
        }
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Id " + id + " not found.");
    }

}
