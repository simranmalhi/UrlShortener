package com.urlshortener.shortener;

import org.junit.jupiter.api.Test;
import java.lang.Object;
import com.urlshortener.shortener.json.LongUrl;
import com.urlshortener.shortener.json.ShortCode;
import com.urlshortener.shortener.service.ShortUrlService;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@ContextConfiguration(classes=ShortenerApplication.class)
//@WebMvcTest(value = ApiController.class) 
class ShortenerApplicationTests {
    // test cases for controller and service
    
        @Autowired
        private MockMvc mockMvc;
        
        @MockBean
        private ShortUrlService service;
        
        String longURL = "http://abcd.com/test";
        
        String shortCode = "abcdfer";
        //@MockBean
        final ShortCode mock = new ShortCode(shortCode);
        
        //@MockBean
        final LongUrl mock2 = new LongUrl(longURL);
        
        //@MockBean
       // private String longUrl = "Greetings Mock";
        
        //@MockBean
       // private String shortCode = "Hello Mock";
        
	@Test
	void longToShort() throws Exception {
            // /*
            when(service.saveUrl(longURL)).thenReturn(mock);
            
            
            this.mockMvc
                    .perform(MockMvcRequestBuilders.post("/api/create?longUrl=" + longURL)
                    .contentType(MediaType.APPLICATION_JSON)                    
                    .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isCreated())
                    .andExpect((ResultMatcher) mock);
            // */
            
             /* when run this code then test works (without Mockito.verify)
            Mockito.when(service.saveUrl(longUrl)).thenReturn(mock);
            
            RequestBuilder rb = MockMvcRequestBuilders.post("/api/create").accept(MediaType.APPLICATION_JSON);
            
            MvcResult mvcResult = mockMvc.perform(rb).andReturn();
            
            System.out.println(mvcResult.getResponse());
            
            //Mockito.verify(service).saveUrl(longUrl); 
             */
	}
        /*
        @Test
        void shortToLong() throws Exception {
            
            
            Mockito.when(service.getUrl("")).thenReturn(mock2); //fix this
            
            RequestBuilder rb = MockMvcRequestBuilders.get("/api/fetch").accept(MediaType.APPLICATION_JSON);
            
            
            MvcResult mvcResult = mockMvc.perform(rb).andReturn();
            
            System.out.println(mvcResult.getResponse());
            
            Mockito.verify(service).getUrl(""); 
        } */

}
