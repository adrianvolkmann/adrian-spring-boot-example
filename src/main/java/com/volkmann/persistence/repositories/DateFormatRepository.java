package com.volkmann.persistence.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volkmann.persistence.entitys.DateFormatEntity;

public interface DateFormatRepository extends JpaRepository<DateFormatEntity, UUID> {

}
