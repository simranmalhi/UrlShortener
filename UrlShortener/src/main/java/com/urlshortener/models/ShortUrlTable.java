/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urlshortener.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity (name = "ShortUrlTable")
//@Table
public class ShortUrlTable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "url_Sequence")
    @SequenceGenerator(name = "url_Sequence", sequenceName = "url_SEQ")
    private int Id;
    
    @Column(name = "longUrl")
    private String longUrl;
    
    @Column(name = "shortCode")
    private String shortCode;
    
    //@Column(name = "createdDate")
    @Column(name = "createdDate", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    
    public String getlongUrl() {
        return longUrl;
    }
}
