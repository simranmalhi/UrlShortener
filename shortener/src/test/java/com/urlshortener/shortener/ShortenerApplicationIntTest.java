package com.urlshortener.shortener;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ShortenerApplicationIntTest {
    @LocalServerPort
    int port;
     
    @Autowired
    TestRestTemplate restTemplate;
    
    @Test
    public void saveUrl() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api/create?longUrl=https://testurl.com"),
                HttpMethod.POST,
                entity,
                String.class);        
        
        assertThat(response.getBody().contains("shortCode"));
    }
    
    @Test
    public void getUrl() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity entity = new HttpEntity(headers);
        
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api/fetch?shortCode=ABBBBB"),
                HttpMethod.GET,
                entity,
                String.class);        
        
        assertThat(response.getBody().isEmpty());
    }
    
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}

