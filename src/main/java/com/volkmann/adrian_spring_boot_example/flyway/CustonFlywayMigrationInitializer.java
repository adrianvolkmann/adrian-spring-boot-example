package com.volkmann.adrian_spring_boot_example.flyway;

import java.util.regex.Pattern;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;

public class CustonFlywayMigrationInitializer extends FlywayMigrationInitializer {

	private final String REGEX = "^V20\\d{2}\\.(0[1-9]|1[0-2])\\.(0[1-9]|[12]\\d|3[01])\\.(0\\d|1\\d|2[0-3])\\.[0-5]\\d__[A-Za-z0-9_]+\\.sql$";
	private final Pattern MIGRATION_FILENAME_PATTERN = Pattern.compile(REGEX);

	public CustonFlywayMigrationInitializer(Flyway flyway, FlywayMigrationStrategy migrationStrategy) {
		super(flyway, migrationStrategy);
		validateMigrationNames(flyway);
	}

	private void validateMigrationNames(Flyway flyway) {
		MigrationInfo[] migrationInfos = flyway.info().all();

		for (MigrationInfo migrationInfo : migrationInfos) {

			boolean isMigrationNameValid = MIGRATION_FILENAME_PATTERN.matcher(migrationInfo.getScript()).matches();

			if (!isMigrationNameValid) {
				throw new IllegalStateException("Invalid migration names detected. The application cannot start.");
			}
		}
	}

}
