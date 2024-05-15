package com.volkmann.persistence.entitys;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private UUID id;
	
	private String name;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
	        name = "Employee_Project", 
	        joinColumns = { @JoinColumn(name = "employee_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "project_id") }
	    )
	private List<Project> projects = new ArrayList<>();

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
}
