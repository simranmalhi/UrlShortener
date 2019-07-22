package com.urlshortener.shortener;

import org.junit.jupiter.api.Test;
/*
import com.urlshortener.shortener.json.LongUrl;
import com.urlshortener.shortener.service.ShortUrlService;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebMvcTest(value = ApiController.class) */
class ShortenerApplicationTests {
    // short to long
    /*
        @Autowired
        private MockMvc mockMvc;
        
        @MockBean
        private ShortUrlService service;
        
        private LongUrl mock = new LongUrl("hi");
        */
	@Test
	void contextLoads() throws Exception {
            /*
            Mockito.when(service.getUrl("")).thenReturn(mock);
            
            RequestBuilder rb = MockMvcRequestBuilders.get("/api/fetch").accept(MediaType.APPLICATION_JSON);
            
            MvcResult mvcResult = mockMvc.perform(rb).andReturn();
            
            System.out.println(mvcResult.getResponse());
            
            Mockito.verify(service).getUrl(""); */
	}

}
