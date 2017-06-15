package com.junehoe.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FirstprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstprojectApplication.class, args);
	}

	@RequestMapping("/")
	public String welcome() {
		return "Hello client! How are you doing?";
	}
	
	@RequestMapping("/random")
	public String springMessage() {
		return "Spring Boot is awesome (kinda). It's easy to hard-code random text.";
	}
}
