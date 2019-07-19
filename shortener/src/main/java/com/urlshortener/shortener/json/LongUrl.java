
package com.urlshortener.shortener.json;


public class LongUrl {
    private static String longUrl;
    
    public LongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
    
    public String getLongUrl() {
        return longUrl;
    }
}
