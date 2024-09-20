package com.volkmann.adrian_spring_boot_example.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class FlywayConfigTeste {

	@Bean(name = "FlywayMigrationInitializerTest")
	FlywayMigrationInitializer flywayInitializer(Flyway flyway, ObjectProvider<FlywayMigrationStrategy> migrationStrategy) {
		System.err.println("EXECUTOU O BEAN DO TESTE");
		return new CustonFlywayMigrationInitializer(flyway, migrationStrategy.getIfAvailable());
	}

}
