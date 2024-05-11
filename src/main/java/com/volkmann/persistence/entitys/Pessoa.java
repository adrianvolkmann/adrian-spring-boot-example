package com.volkmann.persistence.entitys;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
//@Table(name="Pessoa") 
public class Pessoa {

	//verificar padrao de nomemclatura de tabelas
	
	//testar todas conectios
	//spring data queries
	//anotated queries @querie
	
	//gerar queries automagico
	
	//https://medium.com/@zgokceaynaci/spring-jpa-annotations-863574d13121
	
	//como salvar enums
	
	//eager lazy
	
	@Id
	@GeneratedValue
	private UUID id;

//	@Column(name = "name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="pessoa_id")
	private List<Endereco> endereco = new ArrayList<>();

	
	
	//necessario para JPA
	public Pessoa() {
	}

	public Pessoa(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the endereco
	 */
	public List<Endereco> getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
	
//	@OneToMany
//	@ManyToOne
//	@OneToOne
//	@ManyToAny
	
	
	

}
