/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urlshortener.shortener.service;

import com.urlshortener.shortener.models.ShortUrlTable;
import com.urlshortener.shortener.repository.UrlShortenerRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Simi
 */
@Component
public class ShortUrlServiceImplement implements ShortUrlService{
    
    @Autowired
    UrlShortenerRepository repository;
    
    
    @Override
    public String getUrl(String shortCode) {        
        
        
        ShortUrlTable st = repository.findFirstByShortCode(shortCode);
        if(st ==  null)
            return "";
        
        return st.getlongUrl();
    }
    @Override
    public String saveUrl(String longUrl) {
        String shortCode = getShortCode();
        repository.save(toEntity(longUrl, shortCode));
        return shortCode;
        /*
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] letters = {"A", "a", "B", "b", "C", "c", "D", "d", "E", "e", "F",
                        "f", "G", "g", "H", "h", "I", "i", "J", "j", "K", "k",
                        "L", "l", "M", "m", "N", "n", "O", "o", "P", "p", "Q",
                        "q", "R", "r", "S", "s", "T", "t", "U", "u", "V", "v",
                        "W", "w", "X", "x", "Y", "y", "Z", "z"};
        Random gen = new Random();
        String shortCode;
        boolean equals = false;
        
        do {
            shortCode = "";
            for(int i = 0; i < 7; i++) { // generates a shortCode/alias 
                int arrayValue = gen.nextInt(2); 
                int length;
                if(arrayValue == 0) { // a letter will be added to the shortCode
                    length = gen.nextInt(letters.length);
                    shortCode += letters[length];
                }
                else { // a number will be added to the shortCode
                    length = gen.nextInt(numbers.length);
                    shortCode += numbers[length];
                }
            }
            // check to see if shortCode exists in database
            // if yes: equals = true
        } while(equals == true); */
    }
    
    private String getShortCode(){
        // generate a short code 
        //and check against table in db,
        //till you generated an unique code
        String sc = "";
        boolean isUnique = false;
        do{
            //logic to generate the code
            sc = "TASDERT";
            
            // make call to database
            String tempUrl = getUrl(sc);
            if(tempUrl.isEmpty())
                isUnique = true;
            
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
