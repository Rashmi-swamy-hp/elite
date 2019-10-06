package com.example.test;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



//@EnableAutoConfiguration

@SpringBootApplication
@CrossOrigin(origins = "*", allowedHeaders = "*")

@ComponentScan({"com.example.test.dao","com.example.test.controller","com.example.test.init"})
public class TestApplication {
	//private static Class applicationClass = TestApplication.class;
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

//	@RequestMapping("/")
//	String home() {
//		return "Hello World!";
//	}
//	



}
