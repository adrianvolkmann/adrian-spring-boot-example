package com.volkmann.adrian_spring_boot_example.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.volkmann.adrian_spring_boot_example.DTO.DateFormatDTO;
import com.volkmann.adrian_spring_boot_example.entitys.DateFormatEntity;
import com.volkmann.adrian_spring_boot_example.repositories.DateFormatRepository;

import jakarta.validation.Valid;

@RestController
public class DateFormatController {

	
	
	  //"localDateTime" : "2024-06-02T10:19:57.570Z" , 
	  // "localDate" : "2024-06-01" ,
	   //"localTime" : "21:44:24" ,
	   //"zonedDateTime" : "2024-06-01T00:00:00.123456-09:00" 
		   
		   
	@Autowired
	DateFormatRepository dateFormatRepository;
	
	@Autowired 
	private ModelMapper modelMapper;
	
	@PostMapping("/dateFormat")
	public void saveDateFormat(@Valid @RequestBody DateFormatDTO dateFormatDTO) {
		
		
		DateFormatEntity map = modelMapper.map(dateFormatDTO,DateFormatEntity.class);
		
		//DateFormatEntity dateFormatEntity = new DateFormatEntity();
		//dateFormatEntity.setLocalDateTime(LocalDateTime.now());
		dateFormatRepository.save(map);
	}
	
	@GetMapping("/dateFormat")
	public List<DateFormatEntity> getDateFormat() {
		
		System.out.println(LocalDateTime.now());
		
		return dateFormatRepository.findAll();
	}
	
	
}
