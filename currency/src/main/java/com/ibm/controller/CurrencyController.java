package com.ibm.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibm.model.Currency;
import com.ibm.service.CurrencyService;


@RestController
@RequestMapping("/currency")
public class CurrencyController {

	@Autowired
	CurrencyService currencyService;

	@GetMapping
	public List<Currency> getCurrencys() {
		return currencyService.getCurrencys();
	}

	@GetMapping("/cf/{countryCode}")
	public ResponseEntity<Double> getCurrencyFactorByCountryCode(@PathVariable String countryCode) {
		Double result = currencyService.getCurrencyFactorByCountryCode(countryCode);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result)
				.toUri();
		return ResponseEntity.created(location).body(result);
		//return currencyService.getCurrencyFactorByCountryCode(countryCode);
	}

	@PostMapping
	public ResponseEntity<Currency> addCurrency(@RequestBody Currency Currency) {
		Currency result = currencyService.addCurrency(Currency);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId())
				.toUri();
		return ResponseEntity.created(location).body(result);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Currency> updateCurrency(@PathVariable UUID id, @RequestBody Currency Currency) {
		Currency result = currencyService.updateCurrency(Currency);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId())
				.toUri();
		return ResponseEntity.created(location).body(result);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCurrencyById(@PathVariable UUID id) {
		currencyService.deleteCurrency(id);
		return ResponseEntity.noContent().build();
	}
}
