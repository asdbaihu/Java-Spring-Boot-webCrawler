package com.buildit.alejandro.webCrawler.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.buildit.alejandro.webCrawler.controller")

@SpringBootApplication
public class AlejandroWebCrawlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlejandroWebCrawlerApplication.class, args);
	}
}
