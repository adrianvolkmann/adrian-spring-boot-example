package com.volkmann.adrian_spring_boot_example.jpa.onetooneunidirectional;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityARepository extends JpaRepository<EntityA, UUID> {

}
