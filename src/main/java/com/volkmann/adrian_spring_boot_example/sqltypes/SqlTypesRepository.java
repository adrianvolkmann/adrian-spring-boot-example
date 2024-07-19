package com.volkmann.adrian_spring_boot_example.sqltypes;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SqlTypesRepository extends JpaRepository<SqlTypesEntity, UUID> {

}
