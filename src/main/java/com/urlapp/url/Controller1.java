package com.urlapp.url;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.*;

@RestController
@RequestMapping("/api")
public class Controller1 {
    int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    String[] letters = {"A", "a", "B", "b", "C", "c", "D", "d", "E", "e", "F",
                        "f", "G", "g", "H", "h", "I", "i", "J", "j", "K", "k",
                        "L", "l", "M", "m", "N", "n", "O", "o", "P", "p", "Q",
                        "q", "R", "r", "S", "s", "T", "t", "U", "u", "V", "v",
                        "W", "w", "X", "x", "Y", "y", "Z", "z"};
    
    @RequestMapping("/create") // or @RequestMapping(method = RequestMethod.POST)
    public String longToShort(String longUrl) {
        String shortUrl;
        Random gen = new Random();
        do {
            shortUrl = "";
            for(int i = 0; i < 7; i++) {
                int array = gen.nextInt(2);
                int length;
                if(array == 0) { 
                    length = gen.nextInt(letters.length);
                    shortUrl += letters[length];
                }
                else {
                    length = gen.nextInt(numbers.length);
                    shortUrl += numbers[length];
                }
            }
        } while(shortUrl.equals(databaseShortUrl) == true); // Create short url until it doesnt equal
                                                            // an already existing short url.
                                                            // Replace while code with query.
        //code: save long url and short url in database
        return "https://sgshorturl.com/" + shortUrl;
    }
    
    @RequestMapping("/fetch") // or @RequestMapping(method = RequestMethod.GET)
    public void shortToLong() {
        
    }
    
}
