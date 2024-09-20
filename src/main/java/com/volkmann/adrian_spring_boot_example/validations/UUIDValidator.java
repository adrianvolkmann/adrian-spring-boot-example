package com.volkmann.adrian_spring_boot_example.validations;

import java.util.UUID;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UUIDValidator implements ConstraintValidator<ValidUUID, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
//		Garante que a string seja um UUID válido, e não apenas que siga o formato de um UUID.
		if (value == null || value.isEmpty()) {
			return true; // null or empty validation should be handled by @NotNull or @NotEmpty
		}
		try {
			UUID.fromString(value);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

}
