package com.example.demo;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class GoogleMapApplication {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(GoogleMapApplication.class, args);
	}

}
