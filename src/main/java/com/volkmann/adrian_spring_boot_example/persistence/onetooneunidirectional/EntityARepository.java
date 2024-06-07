package com.volkmann.adrian_spring_boot_example.persistence.onetooneunidirectional;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityARepository extends JpaRepository<EntityA, UUID> {

}
