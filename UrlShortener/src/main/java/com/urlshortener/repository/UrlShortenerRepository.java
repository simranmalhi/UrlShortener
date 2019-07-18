/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urlshortener.repository;

import com.urlshortener.models.ShortUrlTable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlShortenerRepository extends JpaRepository<ShortUrlTable, Long> {
    ShortUrlTable findByShortCode(String shortCode);
}