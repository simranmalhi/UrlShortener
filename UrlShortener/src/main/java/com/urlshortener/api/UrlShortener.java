package com.urlshortener.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UrlShortener {

	public static void main(String[] args) {
		SpringApplication.run(UrlShortener.class, args);
	}

}