package com.example.demo.mappers;

import com.example.demo.entities.Person;
import com.example.demo.dtos.PersonDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PersonMapper {

    public PersonMapper() {
    }

    public PersonDto mapp(Person person) {
        return new PersonDto(person.getId(), person.getFirstName(), person.getLastName());
    }

    public Person mapp(PersonDto personDto) {
        return new Person(personDto.getId(), personDto.getFirstName(), personDto.getLastName());
    }

    public Optional<PersonDto> mapp(Optional<Person> optionalPerson) {
        if (optionalPerson.isEmpty())
            return Optional.empty();
        return Optional.of(mapp(optionalPerson.get()));
    }

    public List<PersonDto> mapp(List<Person> all) {
        return all
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }
}