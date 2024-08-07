package com.volkmann.adrian_spring_boot_example.flyway;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.internal.resolver.CompositeMigrationResolver;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig {

	@Bean
    public FlywayMigrationInitializer flywayInitializer(Flyway flyway,
                                                        ObjectProvider<FlywayMigrationStrategy> migrationStrategy) {
        return new MyFlywayMigrationInitializer(flyway, migrationStrategy.getIfAvailable());
    }
	
}
