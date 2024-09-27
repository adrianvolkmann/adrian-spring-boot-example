package com.volkmann.adrian_spring_boot_example.rabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {

	@Autowired
	Producer producer;
	
	@Autowired
	RabbitSpring rabbitSpring;
	
	@PostMapping("/rabbit")
	public void rabbit() {
		producer.enviarMensagem();
		
	}
	
	@PostMapping("/springrabbit")
	public void springrabbit() {
		rabbitSpring.sendMessage("BATATA");
		
	}
}
