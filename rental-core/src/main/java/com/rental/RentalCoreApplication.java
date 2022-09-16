package com.rental;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value="classpath:/package/hsql_cfg.xml")
public class RentalCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalCoreApplication.class, args);
	}

}
