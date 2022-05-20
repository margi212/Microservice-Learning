package com.ibm.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ibm.model.ConvertCurrency;

@Service
public class ConvertCurrencyService {

	@Value("${ms_url}")
	private String ms1Url;
	
	public Double convertCurrency(ConvertCurrency currency) {
		// getCurrencyById(todo.getId());
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Double> response = restTemplate.getForEntity(ms1Url + currency.getCountryCode(),
				Double.class);
		Double cf = response.getBody();
		Double res = cf * currency.getAmount();
		return res;
	}

}
