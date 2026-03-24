package com.generation.localpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.generation.repository")
public class LocalproApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalproApplication.class, args);
	}

}
