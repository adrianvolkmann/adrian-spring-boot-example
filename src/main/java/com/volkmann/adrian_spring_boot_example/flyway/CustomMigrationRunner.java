package com.volkmann.adrian_spring_boot_example.flyway;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class CustomMigrationRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void runCustomMigration() {
		jdbcTemplate.execute("INSERT INTO public.pessoa (id, name) VALUES ('" + UUID.randomUUID().toString() + "','BATATA');");
	}
}
