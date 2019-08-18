package com.example.demo.PayPayGADemoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "*", allowedHeaders = "*")
@ComponentScan({ "com.example.demo.dao", "com.example.demo.controller", "com.example.demo.init",
		"com.example.demo.cofig" })
public class PayPayGaDemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayPayGaDemoAppApplication.class, args);
	}

}
