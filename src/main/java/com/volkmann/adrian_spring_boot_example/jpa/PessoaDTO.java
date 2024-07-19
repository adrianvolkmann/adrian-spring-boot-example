package com.volkmann.adrian_spring_boot_example.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PessoaDTO {

	//justificar pq usar DTO enao diretamene a entidade
	
	public UUID id;
	public String name;
	public List<EnderecoDTO> enderecos = new ArrayList<>();

	//precisa dos getter e setter para o modellMapper Funcionar
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

	public List<EnderecoDTO> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoDTO> enderecos) {
		this.enderecos = enderecos;
	}

}
