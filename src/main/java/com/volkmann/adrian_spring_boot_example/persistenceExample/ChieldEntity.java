package com.volkmann.adrian_spring_boot_example.persistenceExample;

import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "sub")
public class ChieldEntity {

	@Id
	@GeneratedValue
	private UUID id;

	@Email
	@NotNull(message = "Email cannot be null")
	private String email;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private ParentEntity parentEntity;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ParentEntity getParentEntity() {
		return parentEntity;
	}

	public void setParentEntity(ParentEntity parentEntity) {
		this.parentEntity = parentEntity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, parentEntity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChieldEntity other = (ChieldEntity) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(parentEntity, other.parentEntity);
	}

	@Override
	public String toString() {
		return "ChieldEntity [id=" + id + ", email=" + email + ", parentEntity=" + parentEntity + "]";
	}

}
