package com.ibm.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.common.exceptions.CurrencyNotFoundException;
import com.ibm.model.Currency;
import com.ibm.repository.CurrencyRepository;

@Service
public class CurrencyService {

	@Autowired
	CurrencyRepository currencyRepository;

	public List<Currency> getCurrencys() {
		return currencyRepository.findAll();
	}

	public Currency getCurrencyById(UUID id) {
		return currencyRepository.findById(id).orElseThrow(CurrencyNotFoundException::new);
	}

	public Double getCurrencyFactorByCountryCode(String countryCode) {
		return currencyRepository.getCurrencyFactorByCountryCode(countryCode);
	}

	public Currency addCurrency(Currency currency) {
		return currencyRepository.saveAndFlush(currency);
	}

	public Currency updateCurrency(Currency currency) {
		getCurrencyById(currency.getId());
		return currencyRepository.saveAndFlush(currency);
	}

	public boolean deleteCurrency(UUID id) {
		getCurrencyById(id);
		currencyRepository.deleteById(id);
		return true;
	}
}
