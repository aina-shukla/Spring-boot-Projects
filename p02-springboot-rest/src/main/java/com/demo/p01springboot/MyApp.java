package com.demo.p01springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.demo.controllers"})
public class MyApp implements CommandLineRunner {
	
	// responsibility to start
	public static void main(String[] args) {
		SpringApplication.run(MyApp.class, args);
		// logic
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("my app is working");
	}

}
