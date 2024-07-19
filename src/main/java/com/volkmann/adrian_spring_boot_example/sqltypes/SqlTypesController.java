package com.volkmann.adrian_spring_boot_example.sqltypes;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SqlTypesController {

	  //"localDateTime" : "2024-06-02T10:19:57.570Z" , 
	  // "localDate" : "2024-06-01" ,
	   //"localTime" : "21:44:24" ,
	   //"zonedDateTime" : "2024-06-01T00:00:00.123456-09:00" 
		   
		   
	@Autowired
	SqlTypesRepository sqlTypesRepository;
	
	@PostMapping("/sqlTypes")
	public void saveSqlTypesEntity(@RequestBody SqlTypesEntity sqlTypesEntity) {
		//testar
		sqlTypesRepository.save(sqlTypesEntity);
	}
//	
//	@GetMapping("/dateFormat")
//	public List<DateFormatEntity> getDateFormat() {s
//		
//		System.out.println(LocalDateTime.now());
//		
//		return dateFormatRepository.findAll();
//	}
	
	
}
