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
import com.urlshortener.service.ShortUrlService;
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
