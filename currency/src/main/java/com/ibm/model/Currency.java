package com.ibm.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Currency {

	@Id
	@GeneratedValue
	private UUID id;

	private String countryCode;
	
	private Double conversionFactor;

	public Currency() {
		// TODO Auto-generated constructor stub
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Double getAmountCode() {
		return conversionFactor;
	}

	public void setAmountCode(Double amountCode) {
		this.conversionFactor = amountCode;
	}

	@Override
	public String toString() {
		return "Currency [id=" + id + ", countryCode=" + countryCode + ", amountCode=" + conversionFactor + ", getId()="
				+ getId() + ", getCountryCode()=" + getCountryCode() + ", getAmountCode()=" + getAmountCode()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
