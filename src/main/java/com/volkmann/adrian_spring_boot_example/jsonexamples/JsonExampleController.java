package com.volkmann.adrian_spring_boot_example.jsonexamples;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
