
package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureTestRestTemplate
class DemoApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void homeResponse() {
        String body = restTemplate.getForObject("/", String.class);
        assertThat(body).contains("Spring is here!-3");
    }

    @Test
    void echoResponse() {
        String body = restTemplate.getForObject(
                "/echo?msg=Salve", String.class);
        assertThat(body).contains("Echo: Salve");
    }
}

