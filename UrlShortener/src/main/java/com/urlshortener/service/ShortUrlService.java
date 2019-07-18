/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urlshortener.service;

import java.util.List;

/**
 *
 * @author Simi
 */
public interface ShortUrlService {
    public String getUrl(String shortCode); // fetch long url
    public String saveUrl(String longUrl); 
}
