package com.volkmann.adrian_spring_boot_example.jpa;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OneToManyExamplesController {
	
	//controller nao deveria acessar diretamente repository, deveria passar por service
	@Autowired
	PessoaRepository pessoaRepository;
	
//	usar private, muda alguma coisa?
	@Autowired 
	private ModelMapper modelMapper;
	
	@PostMapping("/createPessoa")
	public void createPessoa() {
		
		Pessoa pessoa = new Pessoa("Fulano");
		
		Endereco endereco = new Endereco();
		endereco.setApelido("casa");
		
		Endereco endereco2 = new Endereco();
		endereco2.setApelido("ap");
			
		pessoa.getEnderecos().add(endereco);
		pessoa.getEnderecos().add(endereco2);
		pessoaRepository.save(pessoa);
	}
	
	@GetMapping("/listPessoa")
	public List<PessoaDTO> getPessoa() {
		List<Pessoa> pessoas = pessoaRepository.findAll();
		//no debug, pq exibe hybernate ao inves do objeto real?
		//quando eh lazy
		
//		List<PessoaDTO> collect = pessoas.stream().map(pessoa -> modelMapper.map(pessoa,PessoaDTO.class)).collect(Collectors.toList());
		
		Type listType = new TypeToken<List<PessoaDTO>>(){}.getType();
		List<PessoaDTO> PessoaDTOList = modelMapper.map(pessoas,listType);
		
//		https://www.baeldung.com/java-modelmapper-lists
		
		return PessoaDTOList;
	}

}
