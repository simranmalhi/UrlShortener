package com.urlshortener.shortener;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.when;

import com.urlshortener.shortener.json.LongUrl;
import com.urlshortener.shortener.json.ShortCode;
import com.urlshortener.shortener.service.ShortUrlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(ApiController.class) 
class ShortenerApplicationTest {
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
        
              
	@Test
	void longToShort() throws Exception {          
            when(service.saveUrl(longURL)).thenReturn(mock);
                       
            this.mockMvc
                    .perform(post("/api/create?longUrl=" + longURL)
                    .contentType(MediaType.APPLICATION_JSON)                    
                    .accept(MediaType.APPLICATION_JSON))
                    //.andDo(print())
                    .andExpect(status().isCreated())
                    //.andExpect((ResultMatcher) mock);
                    .andExpect(content().string(containsString(shortCode)));
            // */
            
             /* when run this code then test works (without Mockito.verify)
            Mockito.when(service.saveUrl(longUrl)).thenReturn(mock);
            
            RequestBuilder rb = MockMvcRequestBuilders.post("/api/create").accept(MediaType.APPLICATION_JSON);
            
            MvcResult mvcResult = mockMvc.perform(rb).andReturn();
            
            System.out.println(mvcResult.getResponse());
            
            //Mockito.verify(service).saveUrl(longUrl); 
             */
	}
        
        @Test
        void shortToLong() throws Exception {
            when(service.getUrl(shortCode)).thenReturn(mock2);
            this.mockMvc
                    .perform(get("/api/fetch?shortCode=" + shortCode)
                    .contentType(MediaType.APPLICATION_JSON)                    
                    .accept(MediaType.APPLICATION_JSON))
                    //.andDo(print())
                    .andExpect(status().isOk())
                    //.andExpect((ResultMatcher) mock);
                    .andExpect(content().string(containsString(longURL)));
        } 

}
