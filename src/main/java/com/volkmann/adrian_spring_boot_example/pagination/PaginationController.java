package com.volkmann.adrian_spring_boot_example.pagination;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaginationController {

	// autowired vs inject

	@Autowired
	PaginationRepository paginationRepository;

	/*
      
	  //implementação padrao
	  - agilidade desenvolvimento	  
	  - aceita qualquer parametro, ja abrange novas alteracoes nas entidades
	  - qualquer parametro invalido lanca erro 500
	  - retorno padrao gera mt lixo
	  - nao da para separar o sort do pageable
	  
	  //implementacao customizada
	   - nescessita mais implementaçao
	   - evita erros 500
	   - evita lixo
	   - qualquer novo campo necessita implementaçao
	  
	 */
	
	
//	localhost:8080/pagination-example-default?page=0&size=10&sort=name,asc
	@GetMapping("pagination-example-default")
	public Page<PaginationEntity> paginationExampleDefault(Pageable pageable) {

		Page<PaginationEntity> findAll = paginationRepository.findAll(pageable); // native
		List<PaginationEntity> findAllSort = paginationRepository.findAll(pageable.getSort());// possivel enviar somente sort
		Page<PaginationEntity> findByName = paginationRepository.findByName("Anne Matus", pageable); // custom

		return findAll;
	}

	@GetMapping("pagination-example-custom")
	public PageableResponse paginationExampleCustom(Pageable pageable) {

		Page<PaginationEntity> findAll = paginationRepository.findAll(pageable); // native

		PageableResponse output = new PageableResponse(findAll.getContent(), //
				                                       findAll.getPageable().getPageNumber(), //
				                                       findAll.getPageable().getPageSize(), //
				                                       findAll.getContent().size(), //
				                                       findAll.getTotalPages(), //
				                                       findAll.getTotalElements());
		
		return output;
	}
	
	//why use response entity
	//qual boa pratica pra retornar 
	
	
	//implementacao filtro dynamico
	
}
