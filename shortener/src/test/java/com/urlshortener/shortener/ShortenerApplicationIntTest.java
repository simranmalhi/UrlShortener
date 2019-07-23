
package com.urlshortener.shortener;

/*
import com.urlshortener.shortener.json.LongUrl;
import com.urlshortener.shortener.json.ShortCode;
//import com.urlshortener.shortener.service.ShortUrlService;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
*/

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
    public void getUrl() throws Exception {
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        //headers.set("Accept", "application/json");
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api/fetch?shortCode=ABBBBB"),
                HttpMethod.GET,
                entity,
                String.class);        
        
        assertThat(response.getBody().isEmpty());
    }
    
     @Test
    public void saveUrl() throws Exception {
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        //headers.set("Accept", "application/json");

        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api/create?longUrl=https://testurl.com"),
                HttpMethod.POST,
                entity,
                String.class);        
        
            assertThat(response.getBody().contains("shortCode"));
        }
    
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}


/*
@RunWith(SpringRunner.class)
@WebMvcTest(ApiController.class) 
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ShortenerApplicationIntTest {
      
    String longURL = "http://abcd.com/test";        
    String shortCode = "abcdfer";
    
    @LocalServerPort
    private int port;
     
    @Autowired
    TestRestTemplate restTemplate;
    
    HttpHeaders headers = new HttpHeaders();
    
    @Test
    public void testCreateStudent() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/api/create?longUrl=" + longURL), HttpMethod.POST, entity, String.class);
        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
        assertTrue(actual.contains("/api/create"));
    }    
   /*
    @Test
    public void testRetrieveStudent() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/api/fetch?shortCode=" + shortCode), HttpMethod.GET, entity, String.class);
        String expected = "{\"id\":1,\"name\":\"Rajesh Bhojwani\",\"description\":\"Class 10\"}";
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }
    */
    
    /*
    @Test
    public void saveURL() throws Exception {
        assertThat(
                this
                .restTemplate
                .getForObject("http://localhost:" + port + "/api/create?longUrl=" +longURL,                
                String.class)).contains("Hello World");
    }
    */
    /*
    @Test
    public void getURL() throws Exception {
        assertThat(
                this
                .restTemplate
                .getForObject("http://localhost:" + port + "/api/fetch?shortCode=" +shortCode,                
                String.class)).isNotEmpty();
    }
    */
    //@Autowired
    //private MockMvc mockMvc;
    
   // String longURL = "http://abcd.com/test";
        
    //String shortCode = "abcdfer";
    //@MockBean
       /*                
    @Test
    void longToShort() throws Exception {
        this.mockMvc
            .perform(post("/api/create?longUrl=" + longURL)
            .contentType(MediaType.APPLICATION_JSON)                    
            .accept(MediaType.APPLICATION_JSON))
                    //.andDo(print())
            .andExpect(status().isCreated());
                    //.andExpect((ResultMatcher) mock);
                    //.andExpect(content().string(containsString(shortCode))); 
    }
        
    @Test
    void shortToLong() throws Exception {
        this.mockMvc
            .perform(get("/api/fetch?shortCode=" + shortCode)
            .contentType(MediaType.APPLICATION_JSON)                    
            .accept(MediaType.APPLICATION_JSON))
                    //.andDo(print())
            .andExpect(status().isOk());
                    //.andExpect((ResultMatcher) mock);                    
                    //.andExpect(content().string(containsString(longURL)));
        } 
}
*/

