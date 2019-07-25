package com.urlshortener.shortener.repository;

import com.urlshortener.shortener.models.ShortUrlTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlShortenerRepository extends JpaRepository<ShortUrlTable, Long> {
    ShortUrlTable findFirstByShortCode(String shortCode);
}