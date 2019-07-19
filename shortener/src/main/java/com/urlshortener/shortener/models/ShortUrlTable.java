
package com.urlshortener.shortener.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity 
@Table (name = "ShortUrlTable")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"createdDate"}, allowGetters=true)
public class ShortUrlTable implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int Id;
    
    @Column(name = "long_url", length = 2000)
    private String longUrl;
    
    @Column(name = "short_code", length=7)
    private String shortCode;
    
    //@Column(name = "createdDate")
    @Column(name = "created_date", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    
    //Getters & Setters
    public String getlongUrl() {
        return longUrl;
    }
    
    public String getShortCode(){
        return shortCode;
    }
    
    
    public void setLongUrl(String longURL){
        this.longUrl = longURL;
    }
    
    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
