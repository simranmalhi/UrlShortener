
package com.urlshortener.shortener.service;

import com.urlshortener.shortener.json.LongUrl;
import com.urlshortener.shortener.json.ShortCode;


public interface ShortUrlService {
    LongUrl getUrl(String shortCode); // fetch long url
    ShortCode saveUrl(String longUrl); 
}
