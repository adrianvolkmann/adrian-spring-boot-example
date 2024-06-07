package com.volkmann.adrian_spring_boot_example.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

//verificar como criar um controler base para abstrar um /api

@RestController
public class JsonController {

	@PostMapping("rawJSON")
	public String rawJSON(@RequestBody String body, HttpServletRequest request) {
	
		
		//como validar que input é um json
		
		
		//request.getInputStream();
		
		return body;
	}
	
}
