package com.volkmann.adrian_spring_boot_example.sqltypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SqlTypesController {

	@Autowired
	SqlTypesRepository sqlTypesRepository;

	// Endpoint para criar uma nova entidade
	@PostMapping
	public ResponseEntity<SqlTypesEntity> createSqlTypeEntity(@RequestBody SqlTypesEntity sqlTypesEntity) {
		SqlTypesEntity savedEntity = sqlTypesRepository.save(sqlTypesEntity);
		return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
	}

}
