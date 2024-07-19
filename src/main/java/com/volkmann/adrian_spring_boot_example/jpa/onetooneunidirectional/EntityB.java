package com.volkmann.adrian_spring_boot_example.jpa.onetooneunidirectional;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//OneToOneUnidirectional
@Entity
public class EntityB {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	private String name;

}
