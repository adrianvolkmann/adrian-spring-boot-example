package com.volkmann.adrian_spring_boot_example.memcached;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import net.spy.memcached.MemcachedClient;

@Configuration
@Profile("memcached")
public class MemcachedConfig {

	Logger LOGGER = LoggerFactory.getLogger(MemcachedConfig.class);

	@Value("${memcached.address}")
	private String memcachedAddress;

	@Value("${memcached.port}")
	private int memcachedPort;
	
	@Bean
	MemcachedClient memcachedClient() {
		MemcachedClient memcachet = null;
		try {
			memcachet = new MemcachedClient(new InetSocketAddress(memcachedAddress, memcachedPort));
		} catch (IOException e) {
			LOGGER.error("Error to connect memcached!!!");
		}
		return memcachet;
	}
	
}
