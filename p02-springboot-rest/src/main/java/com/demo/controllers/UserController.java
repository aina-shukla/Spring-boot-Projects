package com.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/greet")
	public String greet() {
		return "Welcome User";
	}
	
	@GetMapping("/greet/{name}")
	public String greet(@PathVariable String name) {
		// logic to capitalize
		return "Welcome "+name;
	}
	
}
