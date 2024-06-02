package com.volkmann.persistence.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.volkmann.persistence.DTO.DateFormatDTO;
import com.volkmann.persistence.entitys.DateFormatEntity;
import com.volkmann.persistence.repositories.DateFormatRepository;

import jakarta.validation.Valid;

@RestController
public class DateFormatController {

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
