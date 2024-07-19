package com.volkmann.adrian_spring_boot_example.sqltypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sql_types")
public class SqlTypesEntity {

	@Id
	@GeneratedValue
	private UUID id;

	private Integer campoInteger;

	private Double campoReal;

	private Boolean campoBoolean;

	private String campoVarcharLimitado;
	
	private String campoVarchar;

	private LocalDate campoLocalDate;

	private LocalTime campoLocalTime;

	private LocalDateTime campoLocalDateTime;

	private ZonedDateTime campoDateTimeZoned;

	@JdbcTypeCode(SqlTypes.JSON)
	private String campoJsonb;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Integer getCampoInteger() {
		return campoInteger;
	}

	public void setCampoInteger(Integer campoInteger) {
		this.campoInteger = campoInteger;
	}

	public Double getCampoReal() {
		return campoReal;
	}

	public void setCampoReal(Double campoReal) {
		this.campoReal = campoReal;
	}

	public Boolean getCampoBoolean() {
		return campoBoolean;
	}

	public void setCampoBoolean(Boolean campoBoolean) {
		this.campoBoolean = campoBoolean;
	}

	public String getCampoVarcharLimitado() {
		return campoVarcharLimitado;
	}

	public void setCampoVarcharLimitado(String campoVarcharLimitado) {
		this.campoVarcharLimitado = campoVarcharLimitado;
	}

	public String getCampoVarchar() {
		return campoVarchar;
	}

	public void setCampoVarchar(String campoVarchar) {
		this.campoVarchar = campoVarchar;
	}

	public LocalDate getCampoLocalDate() {
		return campoLocalDate;
	}

	public void setCampoLocalDate(LocalDate campoLocalDate) {
		this.campoLocalDate = campoLocalDate;
	}

	public LocalTime getCampoLocalTime() {
		return campoLocalTime;
	}

	public void setCampoLocalTime(LocalTime campoLocalTime) {
		this.campoLocalTime = campoLocalTime;
	}

	public LocalDateTime getCampoLocalDateTime() {
		return campoLocalDateTime;
	}

	public void setCampoLocalDateTime(LocalDateTime campoLocalDateTime) {
		this.campoLocalDateTime = campoLocalDateTime;
	}

	public ZonedDateTime getCampoDateTimeZoned() {
		return campoDateTimeZoned;
	}

	public void setCampoDateTimeZoned(ZonedDateTime campoDateTimeZoned) {
		this.campoDateTimeZoned = campoDateTimeZoned;
	}

	public String getCampoJsonb() {
		return campoJsonb;
	}

	public void setCampoJsonb(String campoJsonb) {
		this.campoJsonb = campoJsonb;
	}

	@Override
	public int hashCode() {
		return Objects.hash(campoBoolean, campoDateTimeZoned, campoInteger, campoJsonb, campoLocalDate,
				campoLocalDateTime, campoLocalTime, campoReal, campoVarchar, campoVarcharLimitado, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SqlTypesEntity other = (SqlTypesEntity) obj;
		return Objects.equals(campoBoolean, other.campoBoolean)
				&& Objects.equals(campoDateTimeZoned, other.campoDateTimeZoned)
				&& Objects.equals(campoInteger, other.campoInteger) && Objects.equals(campoJsonb, other.campoJsonb)
				&& Objects.equals(campoLocalDate, other.campoLocalDate)
				&& Objects.equals(campoLocalDateTime, other.campoLocalDateTime)
				&& Objects.equals(campoLocalTime, other.campoLocalTime) && Objects.equals(campoReal, other.campoReal)
				&& Objects.equals(campoVarchar, other.campoVarchar)
				&& Objects.equals(campoVarcharLimitado, other.campoVarcharLimitado) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "SqlTypesEntity [id=" + id + ", campoInteger=" + campoInteger + ", campoReal=" + campoReal
				+ ", campoBoolean=" + campoBoolean + ", campoVarcharLimitado=" + campoVarcharLimitado
				+ ", campoVarchar=" + campoVarchar + ", campoLocalDate=" + campoLocalDate + ", campoLocalTime="
				+ campoLocalTime + ", campoLocalDateTime=" + campoLocalDateTime + ", campoDateTimeZoned="
				+ campoDateTimeZoned + ", campoJsonb=" + campoJsonb + "]";
	}

}
