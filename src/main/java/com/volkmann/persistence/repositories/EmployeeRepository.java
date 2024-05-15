package com.volkmann.persistence.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volkmann.persistence.entitys.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

}
