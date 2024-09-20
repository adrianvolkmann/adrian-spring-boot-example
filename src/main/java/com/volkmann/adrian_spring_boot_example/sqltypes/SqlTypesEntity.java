package com.volkmann.adrian_spring_boot_example.sqltypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sql_types")
public class SqlTypesEntity {

	@Override
	public int hashCode() {
		return Objects.hash(campoBoolean, campoDateTimeZoned, campoDouble, campoEnum, campoEnumString, campoFloat,
				campoInteger, campoJsonb, campoLocalDate, campoLocalDateTime, campoLocalTime, campoVarchar,
				campoVarcharLimitado, id);
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
				&& Objects.equals(campoDouble, other.campoDouble) && campoEnum == other.campoEnum
				&& campoEnumString == other.campoEnumString
				&& Float.floatToIntBits(campoFloat) == Float.floatToIntBits(other.campoFloat)
				&& Objects.equals(campoInteger, other.campoInteger) && Objects.equals(campoJsonb, other.campoJsonb)
				&& Objects.equals(campoLocalDate, other.campoLocalDate)
				&& Objects.equals(campoLocalDateTime, other.campoLocalDateTime)
				&& Objects.equals(campoLocalTime, other.campoLocalTime)
				&& Objects.equals(campoVarchar, other.campoVarchar)
				&& Objects.equals(campoVarcharLimitado, other.campoVarcharLimitado) && Objects.equals(id, other.id);
	}

	@Id
	@GeneratedValue
	private UUID id;

	private Integer campoInteger;

	private float campoFloat;

	private Double campoDouble;

	private Boolean campoBoolean;

	@Column(length = 50)
	private String campoVarcharLimitado;

	private String campoVarchar;

	private LocalDate campoLocalDate;

	private LocalTime campoLocalTime;

	@Override
	public String toString() {
		return "SqlTypesEntity [id=" + id + ", campoInteger=" + campoInteger + ", campoFloat=" + campoFloat
				+ ", campoDouble=" + campoDouble + ", campoBoolean=" + campoBoolean + ", campoVarcharLimitado="
				+ campoVarcharLimitado + ", campoVarchar=" + campoVarchar + ", campoLocalDate=" + campoLocalDate
				+ ", campoLocalTime=" + campoLocalTime + ", campoLocalDateTime=" + campoLocalDateTime
				+ ", campoDateTimeZoned=" + campoDateTimeZoned + ", campoJsonb=" + campoJsonb + ", campoEnum="
				+ campoEnum + ", campoEnumString=" + campoEnumString + "]";
	}

	private LocalDateTime campoLocalDateTime;

	private ZonedDateTime campoDateTimeZoned;

	@JdbcTypeCode(SqlTypes.JSON)
	private String campoJsonb;

	@Enumerated(EnumType.STRING) // Salva o nome do enum no banco de dados
	private EnumField campoEnum;

	@Enumerated(EnumType.STRING) // Salva o nome do enum no banco de dados
	private EnumField campoEnumString;

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

	public float getCampoFloat() {
		return campoFloat;
	}

	public void setCampoFloat(float campoFloat) {
		this.campoFloat = campoFloat;
	}

	public Double getCampoDouble() {
		return campoDouble;
	}

	public void setCampoDouble(Double campoDouble) {
		this.campoDouble = campoDouble;
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

	public EnumField getCampoEnum() {
		return campoEnum;
	}

	public void setCampoEnum(EnumField campoEnum) {
		this.campoEnum = campoEnum;
	}

	public EnumField getCampoEnumString() {
		return campoEnumString;
	}

	public void setCampoEnumString(EnumField campoEnumString) {
		this.campoEnumString = campoEnumString;
	}

}
