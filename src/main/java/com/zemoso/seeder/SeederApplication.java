package com.zemoso.seeder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SeederApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeederApplication.class, args);
	}

}
