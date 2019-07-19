
package com.urlshortener.shortener.service;

import com.urlshortener.shortener.models.ShortUrlTable;
import com.urlshortener.shortener.repository.UrlShortenerRepository;
import java.util.Date;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ShortUrlServiceImplement implements ShortUrlService{
    @Autowired
    UrlShortenerRepository repository;

    @Override
    public String getUrl(String shortCode) {        
        ShortUrlTable st = repository.findFirstByShortCode(shortCode);
        if(st ==  null) {
            return "";
        }
        return st.getlongUrl();
    }
    @Override
    public String saveUrl(String longUrl) {
        String shortCode = getShortCode();
        repository.save(toEntity(longUrl, shortCode));
        return shortCode;
    }
    
    private String getShortCode(){
        // generate a short code 
        //and check against table in db,
        //till you generated an unique code
        Random gen = new Random();
        String sc = "";
        boolean isUnique = false;
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] letters = {"A", "a", "B", "b", "C", "c", "D", "d", "E", "e", "F",
                        "f", "G", "g", "H", "h", "I", "i", "J", "j", "K", "k",
                        "L", "l", "M", "m", "N", "n", "O", "o", "P", "p", "Q",
                        "q", "R", "r", "S", "s", "T", "t", "U", "u", "V", "v",
                        "W", "w", "X", "x", "Y", "y", "Z", "z"};
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
                // makes call to database to see if shortCode exists
                String tempUrl = getUrl(sc);
                if(tempUrl.isEmpty() == true) { // if not then exit loop
                    isUnique = true;
                }
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
