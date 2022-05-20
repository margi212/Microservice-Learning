package com.ibm.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ibm.model.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, UUID> {

	@Query(value = "SELECT c.conversion_factor FROM currency c WHERE c.country_code = ?1", 
			  nativeQuery = true)
	public Double getCurrencyFactorByCountryCode(String countryCode);

}
