package com.volkmann.persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersistenceApplication {

	//diferenca shutdowns projetos
	
	public static void main(String[] args) {
		SpringApplication.run(PersistenceApplication.class, args);
	}

	//testar profiles
	
	//modell mapper
	
	//https://dev.to/kirekov/flyway-migrations-naming-strategy-in-a-big-project-51fp
	//https://www.red-gate.com/blog/database-devops/flyway-naming-patterns-matter
	
	
	/*
	 
	 criar docker compose
	 
    docker run \
    --name postgres \
    -p 5432:5432 \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_PASSWORD=postgres \
    -e POSTGRES_DB=postgres \
    -d postgres


	 */
	
	//https://www.baeldung.com/java-entity-vs-dto
}
