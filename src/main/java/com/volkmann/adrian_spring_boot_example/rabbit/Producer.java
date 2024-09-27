package com.volkmann.adrian_spring_boot_example.rabbit;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

@Component
public class Producer {

	private final static String QUEUE_NAME = "hello";

	public void enviarMensagem() {
		// Criação da conexão com RabbitMQ
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost"); // RabbitMQ está rodando localmente
		factory.setUsername("admin");  // Usuário definido no RabbitMQ
		factory.setPassword("admin");  // Senha definida no RabbitMQ
		
		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			// Declaração da fila "hello"
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			String message = "Hello World!";
			// Envio da mensagem para a fila
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			System.out.println(" [x] Enviado: '" + message + "'");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
