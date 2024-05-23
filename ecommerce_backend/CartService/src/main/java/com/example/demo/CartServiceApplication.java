package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com"})
@EnableMongoRepositories("com.example.demo.Repositories")
@ComponentScan("com.example.demo.controller")
@ComponentScan("com.example.demo.Services")
@EntityScan("com.example.demo.models")
@ComponentScan("com.example.demo.dto")
//@CrossOrigin("*")
public class CartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartServiceApplication.class, args);
	
		System.out.println("Cart is running ");
	}

}
