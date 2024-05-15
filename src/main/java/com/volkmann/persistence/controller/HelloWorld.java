package com.volkmann.persistence.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.volkmann.persistence.DTO.EnderecoDTO;
import com.volkmann.persistence.DTO.PessoaDTO;
import com.volkmann.persistence.entitys.Endereco;
import com.volkmann.persistence.entitys.Pessoa;
import com.volkmann.persistence.repositories.PessoaRepository;

import org.modelmapper.TypeToken;
import java.lang.reflect.Type;


@RestController
public class HelloWorld {
	
	//controller nao deveria acessar diretamente repository, deveria passar por service
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired 
	private ModelMapper modelMapper;
	
	@PostMapping("hello")
	public String helloWorld() {
		
		Pessoa pessoa = new Pessoa("Fulano");
		
		Endereco endereco = new Endereco();
		endereco.setApelido("casa");
		
		Endereco endereco2 = new Endereco();
		endereco2.setApelido("ap");
			
		pessoa.getEnderecos().add(endereco);
		pessoa.getEnderecos().add(endereco2);
		pessoaRepository.save(pessoa);
		
		return "Hello World!";
	}
	
	@GetMapping("getPessoa")
	public List<PessoaDTO> getPessoa() {
		//nova versao usa getReferenceById ao inves de getById
		//Pessoa pessoaEntity = pessoaRepository.getReferenceById(UUID.fromString("a7303ff6-b5c1-4ad8-9185-e617d76baab4"));
		
		List<Pessoa> pessoas = pessoaRepository.findAll();
		
		//no debug, pq exibe hybernate ao inves do objeto real?
		
		PessoaDTO pessoaDTO = modelMapper.map(pessoas.get(0), PessoaDTO.class);
		
		List<PessoaDTO> collect = pessoas.stream().map(pessoa -> modelMapper.map(pessoa,PessoaDTO.class))
		.collect(Collectors.toList());
		
		Type listType = new TypeToken<List<PessoaDTO>>(){}.getType();
		List<PessoaDTO> postDtoList = modelMapper.map(pessoas,listType);
		
		
//		https://www.baeldung.com/java-modelmapper-lists
		
		return collect;
	}

}
