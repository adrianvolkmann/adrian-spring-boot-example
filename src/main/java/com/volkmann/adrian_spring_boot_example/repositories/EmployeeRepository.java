package com.volkmann.adrian_spring_boot_example.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volkmann.adrian_spring_boot_example.entitys.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

}
