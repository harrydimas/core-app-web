package com.app.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CoreAppWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreAppWebApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		//test
		//1
		//2
		//3
		return new BCryptPasswordEncoder();
	}
}
