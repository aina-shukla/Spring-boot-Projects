package com.demo.p01springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class MyApp implements CommandLineRunner {
	
	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(MyApp.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Jdk path: "+env.getProperty("JAVA_HOME"));
		System.out.println("Maven path: "+env.getProperty("MAVEN_HOME"));
		System.out.println("Env: "+env.getProperty("env"));
	}

}
