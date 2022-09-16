package com.rental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(RentalCoreApplication.class)
public class RentalWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalWebApplication.class, args);
	}

}
