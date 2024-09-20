package com.volkmann.adrian_spring_boot_example.persistenceExample;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentEntityRepository extends JpaRepository<ParentEntity, UUID> {

}
