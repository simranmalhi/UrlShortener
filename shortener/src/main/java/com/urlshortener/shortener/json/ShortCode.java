package com.urlshortener.shortener.json;

public class ShortCode {
    private String shortCode;

    public ShortCode(String shortCode) {
        this.shortCode = shortCode;
    }
    
    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }
    
    public String getShortCode() {
        return shortCode;
    }
}
