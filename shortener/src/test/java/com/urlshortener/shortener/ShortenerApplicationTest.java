package com.urlshortener.shortener;

import org.junit.Test;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(ApiController.class) 
public class ShortenerApplicationTest {
        @Autowired
        private MockMvc mockMvc;
        
        @MockBean
        private ShortUrlService service;
        
        String longURL = "http://abcd.com/test";
        String shortCode = "abcdfer";
        final ShortCode mock = new ShortCode(shortCode);
        final LongUrl mock2 = new LongUrl(longURL);
              
	@Test
	public void longToShort() throws Exception {          
            when(service.saveUrl(longURL)).thenReturn(mock);
                       
            this.mockMvc
                    .perform(post("/api/create?longUrl=" + longURL)
                    .contentType(MediaType.APPLICATION_JSON)                    
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated())
                    .andExpect(content().string(containsString(shortCode)));
	}
        
        @Test
        public void shortToLong() throws Exception {
            when(service.getUrl(shortCode)).thenReturn(mock2);
            this.mockMvc
                    .perform(get("/api/fetch?shortCode=" + shortCode)
                    .contentType(MediaType.APPLICATION_JSON)                    
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString(longURL)));
        } 

}
