package com.volkmann.adrian_spring_boot_example.jpa.onetooneunidirectional;

import java.util.UUID;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//OneToOneUnidirectional
@Entity
public class EntityA {

	//criar documentacao por que usar uuid ao inves de sequencial id
	@Id
	@GeneratedValue
	private UUID id;
	
	private String name;
	
	//verificar anotacao
	//private EntityB entityB;
	
	
	//criar sql do relacionando, verificar onde salvar
	
	//pegar documentacao unidirecional bidirecional,composição e agregacao
}
