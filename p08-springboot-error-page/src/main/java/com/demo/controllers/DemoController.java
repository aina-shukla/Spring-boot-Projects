package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@RestController = @Controller + @ResponseBody
@Controller
public class DemoController {

	@GetMapping("hello")
	@ResponseBody
	public String sayHello1() {
		System.out.println("in say hello method");
		return "hello";// path of view prefix and suffix
	}

	@GetMapping("greet")
	public String sayHello() {
		System.out.println("in say hello method");
		return "hello";// path of view prefix and suffix
	}
	
	
	// 500
	@GetMapping("/name")
	public String method1() {
		String name = new String();
		return name.charAt(0)+"";
	}
	
	// post -> /name -> 405
	@PostMapping("/abc")
	@ResponseBody
	public String method2() {
		return "welcome";
	}
	
	// get -> /demo -> 404	
	
	
}
