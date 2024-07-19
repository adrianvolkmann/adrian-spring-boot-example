package com.volkmann.adrian_spring_boot_example.jsonexamples;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityWithJsonRepository extends JpaRepository<EntityWithJson, UUID> {

}
