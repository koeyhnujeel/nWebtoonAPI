package com.example.nWebtoonAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NWebtoonApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NWebtoonApiApplication.class, args);
	}

}
