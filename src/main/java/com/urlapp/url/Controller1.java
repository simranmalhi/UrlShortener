package com.urlapp.url;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import newpackage.Resource1;

@RestController
@RequestMapping("/api")
public class Controller1 {
    @RequestMapping(value = "/resource", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE}    )
    public ResponseEntity<String> TestMethod(@RequestBody Resource1 resource) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException{
        return new ResponseEntity<String>(resource.longUrl, HttpStatus.OK);
    }
    /*int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
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
        
    } */
    
}
