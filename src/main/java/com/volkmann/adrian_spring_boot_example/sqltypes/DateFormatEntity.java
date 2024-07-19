package com.volkmann.adrian_spring_boot_example.sqltypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="date_format")
public class DateFormatEntity {
	
	//https://stackoverflow.com/questions/42194571/identifying-time-zones-in-iso-8601
	
	@Id
	@GeneratedValue
	private UUID id;
	
	private LocalDateTime localDateTime;
	
	private LocalDate localDate;

	private LocalTime localTime;

	private ZonedDateTime zonedDateTime;

	
	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public LocalTime getLocalTime() {
		return localTime;
	}

	public void setLocalTime(LocalTime localTime) {
		this.localTime = localTime;
	}

	public ZonedDateTime getZonedDateTime() {
		return zonedDateTime;
	}

	public void setZonedDateTime(ZonedDateTime zonedDateTime) {
		this.zonedDateTime = zonedDateTime;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTimes) {
		this.localDateTime = localDateTimes;
	}
	
}
