package com.volkmann.adrian_spring_boot_example.persistenceExample;

import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record ChildDTO(
		UUID id,

		@Email(message = "Email should be valid")
		@NotNull(message = "Email cannot be null")
		String email
	
	) {

}
