
package com.urlshortener.shortener.service;


public interface ShortUrlService {
     String getUrl(String shortCode); // fetch long url
     String saveUrl(String longUrl); 
}
