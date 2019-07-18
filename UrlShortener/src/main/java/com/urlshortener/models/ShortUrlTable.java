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
import javax.persistence.Table;

@Entity (name = "ShortUrlTable")
//@Table
public class ShortUrlTable {
    @Id
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "player_Sequence")
    //@SequenceGenerator(name = "player_Sequence", sequenceName = "PLAYER_SEQ")
    private int Id;
    
    @Column(name = "longUrl")
    private String longUrl;
    
    @Column(name = "shortCode")
    private String shortCode;
    
    @Column(name = "createdDate")
    private Date createdDate;
}
