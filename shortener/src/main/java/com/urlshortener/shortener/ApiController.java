/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urlshortener.shortener;


import com.urlshortener.shortener.service.ShortUrlService;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import java.sql.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired 
    ShortUrlService service;
    
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE}    )
    public ResponseEntity<String> longToShort(@RequestBody String longUrl) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, SQLException, ClassNotFoundException{
        return new ResponseEntity<String>(service.saveUrl(longUrl), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/fetch", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE}    )
    public ResponseEntity<String> shortToLong(String shortCode) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException{
        return new ResponseEntity<String>(service.getUrl(shortCode), HttpStatus.OK);
    }  
}
