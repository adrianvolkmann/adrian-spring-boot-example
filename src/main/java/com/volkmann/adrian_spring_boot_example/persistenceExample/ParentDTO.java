package com.volkmann.adrian_spring_boot_example.persistenceExample;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record ParentDTO(

		//alternativa é usar @Pattern
		//custom validator, performatico
		//@ValidUUID(message = "Invalid UUID format")
	    UUID id,

	    @NotNull(message = "Name cannot be null")
	    @NotEmpty(message = "Name cannot be empty")
	    @NotBlank(message = "Name cannot be blank")
	    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
	    String name,

	    @Email(message = "Email should be valid")
	    @NotNull(message = "Email cannot be null")
	    String email,

	    @NotNull(message = "Password cannot be null")
	    @Size(min = 8, message = "Password must be at least 8 characters")
	    String password,

	    @Min(value = 0, message = "Age must be greater than or equal to 0")
	    @Max(value = 120, message = "Age must be less than or equal to 120")
	    Integer age,

	    @PositiveOrZero(message = "Balance must be zero or positive")
	    Double balance,

	    @NegativeOrZero(message = "Credit must be negative or zero")
	    Double credit,

	    @Size(min = 1, message = "There must be at least 1 sub-entity")
	    @Valid // Validação dos campos da entidade filha
	    List<ChildDTO> subEntities
	) {}