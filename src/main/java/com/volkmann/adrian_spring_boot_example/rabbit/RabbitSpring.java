package com.volkmann.adrian_spring_boot_example.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitSpring {
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	
	public void sendMessage(String message) {
        rabbitTemplate.convertAndSend("hello", message);
        System.out.println("Message Sent: " + message);
    }

}
