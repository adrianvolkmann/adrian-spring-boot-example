package com.volkmann.persistence.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.volkmann.persistence.DTO.EnderecoDTO;
import com.volkmann.persistence.DTO.PessoaDTO;
import com.volkmann.persistence.entitys.Endereco;
import com.volkmann.persistence.entitys.Pessoa;
import com.volkmann.persistence.repositories.PessoaRepository;


@RestController
public class HelloWorld {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@PostMapping("hello")
	public String helloWorld() {
		
		Pessoa pessoa = new Pessoa("Fulano");
		
		Endereco endereco = new Endereco();
		endereco.setApelido("casa");
			
		pessoa.getEndereco().add(endereco);
		pessoaRepository.save(pessoa);
		
		return "Hello World!";
	}
	
	@GetMapping("getPessoa")
	public PessoaDTO getPessoa() {
		
		Pessoa pessoaEntity = pessoaRepository.getReferenceById(UUID.fromString("a7303ff6-b5c1-4ad8-9185-e617d76baab4"));
		
		//pq exibe hybernate ao inves do objeto real?
		
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		enderecoDTO.id=pessoaEntity.getEndereco().get(0).getId();
		enderecoDTO.apelido=pessoaEntity.getEndereco().get(0).getApelido();
		
		PessoaDTO pessoaDTO = new PessoaDTO();
		pessoaDTO.id=pessoaEntity.getId();
		pessoaDTO.name=pessoaEntity.getName();
		pessoaDTO.enderecos=List.of(enderecoDTO);
		
		return pessoaDTO;
	}

}
