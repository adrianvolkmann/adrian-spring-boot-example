package com.volkmann.adrian_spring_boot_example.flyway;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;
import org.flywaydb.core.api.configuration.Configuration;
import org.flywaydb.core.api.output.MigrateResult;
import org.flywaydb.core.api.resolver.ResolvedMigration;
import org.flywaydb.core.api.resource.LoadableResource;
import org.flywaydb.core.internal.resolver.CompositeMigrationResolver;
import org.flywaydb.core.internal.scanner.filesystem.FileSystemScanner;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;



public class MyFlywayMigrationInitializer extends FlywayMigrationInitializer {

//	https://github.com/flyway/flyway/issues/1608
	
	public MyFlywayMigrationInitializer(Flyway flyway, FlywayMigrationStrategy migrationStrategy) {
		super(flyway, migrationStrategy);

		Configuration configuration = flyway.getConfiguration();

		Location[] locations = configuration.getLocations();


		FileSystemScanner scanner  = new FileSystemScanner( StandardCharsets.UTF_8, false, false, false);

		scanner.scanForResources(locations[0]);
		
//		MigrateResult migrate = flyway.migrate();
		System.out.println("debug");
	}

//	public void afterPropertiesSet() throws Exception {
//		// no-op. We don't want to run the migrations at startup
////		log.debug("Not running Flyway migrations at application startup");
//		System.out.println("AKE");
//	}
	


}
