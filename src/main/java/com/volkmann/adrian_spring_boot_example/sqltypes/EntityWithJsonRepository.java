package com.volkmann.adrian_spring_boot_example.sqltypes;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volkmann.adrian_spring_boot_example.jsonexamples.EntityWithJson;

public interface EntityWithJsonRepository extends JpaRepository<EntityWithJson, UUID> {

}
