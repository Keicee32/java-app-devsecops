package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        // Verifies that the Spring application context loads.
    }

    @Test
    void homeResponse() {
        String body = this.restTemplate.getForObject("/", String.class);
        assertThat(body).contains("Spring is here!-3");
    }

    @Test
    void echoResponse() {
        String body = this.restTemplate.getForObject(
                "/echo?msg=Salve", String.class);
        assertThat(body).contains("Echo: Salve");
    }
}

