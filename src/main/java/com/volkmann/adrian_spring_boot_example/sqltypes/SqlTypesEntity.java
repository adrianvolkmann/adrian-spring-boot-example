package com.volkmann.adrian_spring_boot_example.sqltypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sql_types")
public class SqlTypesEntity {

	@Id
	@GeneratedValue
	private UUID id;

	private Integer campoInteger;

	private float campoFloat;
	
	private Double campoDouble;

	private Boolean campoBoolean;

	@Column(length = 50)
	private String campoVarcharLimitado;
	
	private String campoVarchar;

	private LocalDate campoLocalDate;

	private LocalTime campoLocalTime;

	private LocalDateTime campoLocalDateTime;

	private ZonedDateTime campoDateTimeZoned;

	@JdbcTypeCode(SqlTypes.JSON)
	private String campoJsonb;
	
	
	//@Enumerated(EnumType.STRING) // Usa EnumType.STRING para armazenar o nome do enum no banco
	//gerar enum

	//gerar gettter e setter

	//testar
	//CREATE TYPE order_status AS ENUM ('PENDING', 'SHIPPED', 'DELIVERED', 'CANCELLED');
	

}
