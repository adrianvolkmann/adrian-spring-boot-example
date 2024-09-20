package com.volkmann.adrian_spring_boot_example.persistenceExample;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.volkmann.adrian_spring_boot_example.validations.ValidUUID;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/parent")
public class ParentController {

	// porque usar construtor e nao autowired

	private final ParentEntityRepository parentRepository;
	private final ModelMapper modelMapper;

	public ParentController(ParentEntityRepository parentRepository, ModelMapper modelMapper) {
		this.parentRepository = parentRepository;
		this.modelMapper = modelMapper;
	}

	//analisar consumo de memoria na abordagem abaixo
//	salvar entity em memoria, converter denovo para retornar
	
	
	@PostMapping
	public ResponseEntity<ParentDTO> createParent(@Valid @RequestBody ParentDTO parentDTO) {
		ParentEntity parentEntity = modelMapper.map(parentDTO, ParentEntity.class);
		ParentEntity savedParent = parentRepository.save(parentEntity);
		ParentDTO responseDTO = modelMapper.map(savedParent, ParentDTO.class);
		return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
	}

	//@ValidUUID custom validator
	@GetMapping("/{id}")
	public ResponseEntity<ParentDTO> getParent(@PathVariable @ValidUUID UUID id) {
		return parentRepository.findById(id).map(parent -> modelMapper.map(parent, ParentDTO.class))
				.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	//nao usou paginacao
	@GetMapping
	public List<ParentDTO> getAllParents() {
		return parentRepository.findAll().stream().map(parent -> modelMapper.map(parent, ParentDTO.class))
				.collect(Collectors.toList());
	}

	@PutMapping("/{id}")
	public ResponseEntity<ParentDTO> updateParent(@PathVariable UUID id, @Valid @RequestBody ParentDTO parentDTO) {
		return parentRepository.findById(id).map(existingParent -> {
			modelMapper.map(parentDTO, existingParent);
			ParentEntity updatedParent = parentRepository.save(existingParent);
			return ResponseEntity.ok(modelMapper.map(updatedParent, ParentDTO.class));
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteParent(@PathVariable @ValidUUID UUID id) {
		return parentRepository.findById(id).map(parent -> {
			parentRepository.delete(parent);
			return ResponseEntity.noContent().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
