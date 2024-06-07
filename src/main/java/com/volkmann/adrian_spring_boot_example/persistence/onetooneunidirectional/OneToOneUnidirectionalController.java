package com.volkmann.adrian_spring_boot_example.persistence.onetooneunidirectional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneToOneUnidirectionalController {

	// pegar documentacao de nomes de endpoints/api
	// verificar path api antes dos endpoints, para aplicacão de regras etc

	@Autowired // pq autowired, nao @Inject
	EntityARepository entityARepository;

	@PostMapping("oneToOneUnidirectional")
	public void saveOneToOneUnidirectional(@RequestBody EntityA entityA) {
		entityARepository.save(entityA);
	}

	@GetMapping("oneToOneUnidirectional")
	public List<EntityA> listOneToOneUnidirectional() {
		return entityARepository.findAll();
	}
}

//onde salvar JSON examplo
