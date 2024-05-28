package com.volkmann.persistence.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volkmann.persistence.entitys.EntityWithJson;

public interface EntityWithJsonRepository extends JpaRepository<EntityWithJson, UUID> {

}
