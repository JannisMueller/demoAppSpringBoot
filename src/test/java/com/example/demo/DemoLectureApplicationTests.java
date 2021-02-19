package com.example.demo;

import com.example.demo.dtos.PersonDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class DemoLectureApplicationTests {

    @Autowired
    TestRestTemplate testClient;

    @Test
    void contextLoads() {

        var result = testClient.getForEntity("http://localhost:5050/persons/" , PersonDto[].class);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody().length).isGreaterThan(0);
    }

}
