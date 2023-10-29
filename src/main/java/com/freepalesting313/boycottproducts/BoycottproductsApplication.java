package com.freepalesting313.boycottproducts;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class BoycottproductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoycottproductsApplication.class, args);
		System.out.println("Hello world, Free Palestine");
	}

	@Bean
	public WebClient webClient() {
		final int size = 16 * 1024 * 1024;
		final ExchangeStrategies strategies = ExchangeStrategies.builder()
				.codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
				.build();
		return WebClient.builder().exchangeStrategies(strategies).build();
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

}
