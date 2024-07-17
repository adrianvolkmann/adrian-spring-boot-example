package com.volkmann.adrian_spring_boot_example.pagination;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaginationRepository extends JpaRepository<PaginationEntity, UUID> {

	Page<PaginationEntity> findByName(String name, Pageable pageable);

}
