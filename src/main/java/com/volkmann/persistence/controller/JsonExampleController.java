package com.volkmann.persistence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.volkmann.persistence.entitys.EntityWithJson;
import com.volkmann.persistence.repositories.EntityWithJsonRepository;

@RestController
public class JsonExampleController {

	@Autowired
	EntityWithJsonRepository entityWithJsonRepository;
	
	@PostMapping("/testJson")
	public void saveTest() {
		
		EntityWithJson entityWithJson = new EntityWithJson();
		entityWithJson.setName("qlq coisa");
		
		
		entityWithJson.setJsonBField("{\"message\":\"" + "TESTE" + "\"}");
		
		
		entityWithJsonRepository.save(entityWithJson);
	}
	
	@GetMapping("/testJson")
	public List<EntityWithJson> listTest() {
		return entityWithJsonRepository.findAll();
	}
	
}
