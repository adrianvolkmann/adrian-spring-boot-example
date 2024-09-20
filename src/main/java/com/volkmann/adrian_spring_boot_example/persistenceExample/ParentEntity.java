package com.volkmann.adrian_spring_boot_example.persistenceExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

@Entity
@Table(name = "validation")
public class ParentEntity {

	@Id
	@GeneratedValue
	private UUID id;

	@NotNull(message = "Name cannot be null")
	@NotEmpty(message = "Name cannot be empty")
	@NotBlank(message = "Name cannot be blank")
	@Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
	private String name;

	// se nao especificar mensagem, ja tem comum com traducao
	@Email
	@NotNull(message = "Email cannot be null")
	private String email;

	@NotNull(message = "Password cannot be null")
	@Size(min = 8, message = "Password must be at least 8 characters")
	private String password;

	@Min(value = 0, message = "Age must be greater than or equal to 0")
	@Max(value = 120, message = "Age must be less than or equal to 120")
	private Integer age;

	@PositiveOrZero(message = "Balance must be zero or positive")
	private Double balance;

	@NegativeOrZero(message = "Credit must be negative or zero")
	private Double credit;

	// Relacionamento um-para-muitos com SubEntity
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "parent_id") // Chave estrangeira na SubEntity
	@Size(min = 1)
	@Valid // testar, deveria validar campos da subentidade
	private List<ChieldEntity> subEntities = new ArrayList<>();

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getCredit() {
		return credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public List<ChieldEntity> getSubEntities() {
		return subEntities;
	}

	public void setSubEntities(List<ChieldEntity> subEntities) {
		this.subEntities = subEntities;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, balance, credit, email, id, name, password, subEntities);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParentEntity other = (ParentEntity) obj;
		return Objects.equals(age, other.age) && Objects.equals(balance, other.balance)
				&& Objects.equals(credit, other.credit) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(subEntities, other.subEntities);
	}

	@Override
	public String toString() {
		return "ParentEntity [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", age="
				+ age + ", balance=" + balance + ", credit=" + credit + ", subEntities=" + subEntities + "]";
	}

}
