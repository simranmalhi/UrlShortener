/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urlshortener.api;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@EntityListeners(AuditingEntityListener.class) // does this need to be here?
@JsonIgnoreProperties(value = {"createdDate"}, 
        allowGetters = true)

@RestController
@RequestMapping("/api")
public class ApiController {
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE}    )
    public ResponseEntity<String> longToShort(@RequestBody String longUrl) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, SQLException, ClassNotFoundException{
        // connect to MySQL Database
        String myDriver = "com.mysql.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/mydb?zeroDateTimeBehavior=convertToNull";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "Thedoctor#1");
  
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
        } while(equals == true); 
       
        return new ResponseEntity<String>(shortCode, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/fetch", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE}    )
    public ResponseEntity<String> shortToLong(String shortCode) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException{
        
        // code needed: database finds long url based on shortCode row
        
        String longUrl = ""; // store long url from database in this variable
        return new ResponseEntity<String>(longUrl, HttpStatus.OK);
    }  
}
