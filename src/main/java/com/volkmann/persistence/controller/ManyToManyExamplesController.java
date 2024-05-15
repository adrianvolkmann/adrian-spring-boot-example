package com.volkmann.persistence.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.volkmann.persistence.DTO.EmployeeDTO;
import com.volkmann.persistence.DTO.ProjectDTO;
import com.volkmann.persistence.entitys.Employee;
import com.volkmann.persistence.entitys.Project;
import com.volkmann.persistence.repositories.EmployeeRepository;
import com.volkmann.persistence.repositories.ProjectRepository;

@RestController
public class ManyToManyExamplesController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired 
	private ModelMapper modelMapper;

	@PostMapping("/createEmployee")
	public void createEmployee() {
		
		Employee employee = new Employee();
		employee.setName("func 1");
		
		Project project1 = new Project();
		project1.setTitle("projeto1");
		employee.getProjects().add(project1);
		
		Project project2 = new Project();
		project2.setTitle("projeto2");
		employee.getProjects().add(project2);
		
		employeeRepository.save(employee);
	}
	
	@GetMapping("/listEmployee")
	public List<EmployeeDTO> getEmployee() {
	
		List<Employee> employeesList = employeeRepository.findAll();
		
		Type listType = new TypeToken<List<EmployeeDTO>>(){}.getType();
		List<EmployeeDTO> EmployeeDTOlist = modelMapper.map(employeesList,listType);
		
		return EmployeeDTOlist;
	}
	
	@GetMapping("/listProjects")
	public List<ProjectDTO> getProjects() {
	
		List<Project> projectList = projectRepository.findAll();
		
		Type listType = new TypeToken<List<ProjectDTO>>(){}.getType();
		List<ProjectDTO> ProjectDTOlist = modelMapper.map(projectList,listType);
		
		return ProjectDTOlist;
	}
	
}
