package com.example.webservicetest;

import com.example.webservicetest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebservicetestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WebservicetestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
