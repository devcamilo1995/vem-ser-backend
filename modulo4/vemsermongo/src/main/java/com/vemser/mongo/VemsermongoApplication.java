package com.vemser.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories
public class VemsermongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VemsermongoApplication.class, args);
	}

}
