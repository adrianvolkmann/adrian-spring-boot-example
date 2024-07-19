package com.volkmann.adrian_spring_boot_example.helloworld;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@PostMapping("/helloWorld")
	public String helloWorld() {
		return "Hellow!";
	}
	
}
