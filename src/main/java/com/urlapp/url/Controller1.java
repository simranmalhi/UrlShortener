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

@RestController
@RequestMapping("/api")
public class Controller1 {
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE}    )
    public ResponseEntity<String> longToShort(@RequestBody Resource1 resource) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException{
        // logic goes here
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] letters = {"A", "a", "B", "b", "C", "c", "D", "d", "E", "e", "F",
                        "f", "G", "g", "H", "h", "I", "i", "J", "j", "K", "k",
                        "L", "l", "M", "m", "N", "n", "O", "o", "P", "p", "Q",
                        "q", "R", "r", "S", "s", "T", "t", "U", "u", "V", "v",
                        "W", "w", "X", "x", "Y", "y", "Z", "z"};
        String shortUrl;
        Random gen = new Random();
        do {
            shortCode = "";
            for(int i = 0; i < 7; i++) {
                int array = gen.nextInt(2);
                int length;
                if(array == 0) { 
                    length = gen.nextInt(letters.length);
                    shortCode += letters[length];
                }
                else {
                    length = gen.nextInt(numbers.length);
                    shortCode += numbers[length];
                }
            }
        } while(shortCode.equals(databaseShortUrl) == true); // Create short url until it doesnt equal
                                                             // an already existing short url.
                                                             // Replace while code with query.
        //code: save long url and short url in database
        return new ResponseEntity<String>(resource.shortUrl, HttpStatus.OK);
    }
    @RequestMapping(value = "/fetch", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE}    )
    public ResponseEntity<String> TestMethod2(String shortCode) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException{
        // logic goes here
        return new ResponseEntity<String>(shortCode, HttpStatus.OK);
    }  
}
