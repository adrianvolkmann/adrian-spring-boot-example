package com.volkmann.adrian_spring_boot_example.entitys;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.google.gson.Gson;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//convensao nomemclatura SQL = snake_case

//nomes de tabela no singular
//https://www.databasestar.com/database-table-naming-conventions/

@Entity
@Table(name="Entitie_With_Json") //anotar o padrao de entidade
public class EntityWithJson {

	@Id
	@GeneratedValue
	private UUID id;

//	verificar anotação para tamanho maximo de string
	private String name;
	
	@JdbcTypeCode(SqlTypes.JSON)
	private String jsonBField;
	
	//ver tipos de Json nativo
	//testando
	//private Gson gson = new Gson();
	
	//public void testeGson() {
		
	//}

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

	public String getJsonBField() {
		return jsonBField;
	}

	public void setJsonBField(String jsonBField) {
		this.jsonBField = jsonBField;
	}

}
