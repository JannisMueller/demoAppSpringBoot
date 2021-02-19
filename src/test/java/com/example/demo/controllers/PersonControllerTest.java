package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonControllerTest {

    //Unit test. Testing one thing at a time, in isolation

    @Test
    void callingOneWithValidIdReturnsOnePerson(){ //vi vill inte ha koppling till databas i test,
        // så vi skaffade en interface av PersonService som heter Serivce
        PersonController personController = new PersonController(new TestService());
        
        var person = personController.one(1L);
        
        assertThat(person.getId()).isEqualTo(1);

    }
    @Test
    void callingOneWithInvalidIdThrowsExceptionWithResponseStatus404() {
        PersonController personController = new PersonController(new TestService());

       var exception =  assertThrows(ResponseStatusException.class, () -> personController.one(1L));
       assertThat(exception.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);

    }

}