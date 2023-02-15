package com.example.obspringbootses456.controller;

import com.example.obspringbootses456.entity.Laptop;
import com.example.obspringbootses456.repository.LaptopRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private int port;
    @Autowired
    private LaptopRepository laptopRepository;

    @BeforeEach
    void setUp(){
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:"+port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }


    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response =
                testRestTemplate.getForEntity("/api/laptop", Laptop[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());
        List<Laptop> laptop = Arrays.asList(response.getBody());
        System.out.println(laptop.size());
    }

    @Test
    void findOneBy() {
        ResponseEntity<Laptop[]> response =
                testRestTemplate.getForEntity("/api/laptop/1", Laptop[].class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                
                {
                    
                    "make": "MSI",
                    "model": "GF69",
                    "ram": 16,
                    "videoCard": true,
                    "processor": "i7",
                    "monitor": 15
                  }
                """;
        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Laptop> response =
                testRestTemplate.exchange("/api/laptop", HttpMethod.POST, request ,Laptop.class);
        Laptop result = response.getBody();
        assertEquals(1L, result.getId());
        assertEquals("MSI", result.getMake());

    }

    @Test
    void update() {
     /*   ResponseEntity<Laptop[]> response =
                testRestTemplate.getForEntity("/api/laptop/1", Laptop[].class);
        if (response.getStatusCode() != HttpStatus.NOT_FOUND){
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

            String json = """
                
                {
                    
                    "make": "MSI",
                    "model": "GF69",
                    "ram": 16,
                    "videoCard": true,
                    "processor": "i7",
                    "monitor": 15
                  }
                """;
            HttpEntity<String> request = new HttpEntity<>(json, headers);
            ResponseEntity<Laptop> response1 =
                    testRestTemplate.exchange("/api/laptop", HttpMethod.POST, request ,Laptop.class);
            Laptop result = response1.getBody();

            assertEquals(1L, result.getId());
            assertEquals("MSI", result.getMake());

        }

        */

    }

    @Test
    void delete() {
       /* ResponseEntity<Laptop[]> response =
                testRestTemplate.getForEntity("/api/laptop/1", Laptop[].class);
        if(response.getStatusCode() != HttpStatus.NOT_FOUND){
            laptopRepository.deleteById(1L);
        }
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());*/


    }

    @Test
    void deleteAll() {
        ResponseEntity<Laptop[]> response =
                testRestTemplate.getForEntity("/api/laptop", Laptop[].class);
        List<Laptop> laptop = Arrays.asList(response.getBody());
        laptopRepository.deleteAll(laptop);

        ResponseEntity<Laptop[]> response2 =
                testRestTemplate.getForEntity("/api/laptop/1", Laptop[].class);
        assertEquals(HttpStatus.NOT_FOUND, response2.getStatusCode());


    }
}