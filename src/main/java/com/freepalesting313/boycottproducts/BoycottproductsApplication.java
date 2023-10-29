package com.freepalesting313.boycottproducts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class BoycottproductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoycottproductsApplication.class, args);
		System.out.println("Hello world, Free Palestine");
	}

	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}

}
