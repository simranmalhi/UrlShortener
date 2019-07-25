package com.urlshortener.shortener.service;

import com.urlshortener.shortener.json.LongUrl;
import com.urlshortener.shortener.json.ShortCode;
import com.urlshortener.shortener.models.ShortUrlTable;
import com.urlshortener.shortener.repository.UrlShortenerRepository;
import java.util.Date;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Component
@Service
public class ShortUrlServiceImplement implements ShortUrlService{
    @Autowired
    UrlShortenerRepository repository;

    Random gen = new Random();
    private int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private String[] letters = {"A", "a", "B", "b", "C", "c", "D", "d", "E", "e", "F",
                            "f", "G", "g", "H", "h", "I", "i", "J", "j", "K", "k",
                            "L", "l", "M", "m", "N", "n", "O", "o", "P", "p", "Q",
                            "q", "R", "r", "S", "s", "T", "t", "U", "u", "V", "v",
                            "W", "w", "X", "x", "Y", "y", "Z", "z"};
        
    @Override
    public LongUrl getUrl(String shortCode) {        
        ShortUrlTable st = repository.findFirstByShortCode(shortCode);
        if(st == null) {
            return new LongUrl("error: short code does not exist");
        }
        LongUrl obj = new LongUrl(st.getlongUrl());
        return obj;
    }
    @Override
    public ShortCode saveUrl(String longUrl) {
        String shortCode = getShortCode();
        repository.save(toEntity(longUrl, shortCode));
        ShortCode obj = new ShortCode(shortCode);
        return obj;
    }
    
    private String getShortCode(){
        String sc;
        boolean isUnique = false;
        
        do {
            sc = "";
            for(int i = 0; i < 7; i++) { // generates a shortCode/alias 
                int arrayValue = gen.nextInt(2); 
                if(arrayValue == 0) { // a letter will be added to the shortCode
                    sc += letters[gen.nextInt(letters.length)];
                }
                else { // a number will be added to the shortCode
                    sc += numbers[gen.nextInt(numbers.length)];
                } 
            }    
            
            ShortUrlTable st = repository.findFirstByShortCode(sc);
            if(st ==  null) { // then sc is unique
                isUnique = true;
            }
        }while(isUnique == false);
        
        return sc;
    }
    
    private ShortUrlTable toEntity(String longUrl, String shortCode){
        ShortUrlTable st = new ShortUrlTable();
        st.setLongUrl(longUrl);
        st.setShortCode(shortCode);
        st.setCreatedDate(new Date());
        return st;
    }
}
