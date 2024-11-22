package com.volkmann.adrian_spring_boot_example.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	// Dead Letter Exchange
    @Bean
    public DirectExchange deadLetterExchange() {
        return new DirectExchange("dlx.exchange");
    }

    // Dead Letter Queue
    @Bean
    public Queue deadLetterQueue() {
        return new Queue("dlx.queue");
    }

    // Binding Dead Letter Queue to DLX
    @Bean
    public Binding dlxBinding(Queue deadLetterQueue, DirectExchange deadLetterExchange) {
        return BindingBuilder.bind(deadLetterQueue).to(deadLetterExchange).with("dlx.routing.key");
    }

    // Main Queue with DLX configuration
    @Bean
    public Queue mainQueue() {
        return QueueBuilder.durable("main.queue")
                .withArgument("x-dead-letter-exchange", "dlx.exchange")
                .withArgument("x-dead-letter-routing-key", "dlx.routing.key")
                .build();
    }

    // Exchange for Main Queue
    @Bean
    public DirectExchange mainExchange() {
        return new DirectExchange("main.exchange");
    }

    // Binding Main Queue to Main Exchange
    @Bean
    public Binding mainBinding(Queue mainQueue, DirectExchange mainExchange) {
        return BindingBuilder.bind(mainQueue).to(mainExchange).with("main.routing.key");
    }
	
}
