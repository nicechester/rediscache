package com.chester.rediscache;

import com.google.common.collect.ImmutableList;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@Log4j2
@EnableCaching
@SpringBootApplication
public class RediscacheApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RediscacheApplication.class, args);
	}

	@Autowired private PersonService service;

	@Override
	public void run(String... strings) {
		log.info("Getting users...");
		ImmutableList.of("Chester", "Liz", "Isaac", "Mike", "Jamie")
				.stream()
				.map(service::getPerson)
				.forEach(log::info);
	}
}
