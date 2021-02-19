package com.example.demo.mappers;

import com.example.demo.Person;
import com.example.demo.PersonDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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