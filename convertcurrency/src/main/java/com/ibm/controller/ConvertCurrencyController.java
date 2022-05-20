package com.ibm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.model.ConvertCurrency;
import com.ibm.service.ConvertCurrencyService;

@RestController
@RequestMapping("/convert-currency")
public class ConvertCurrencyController {

	@Autowired
	ConvertCurrencyService convertCurrencyService;

	@PostMapping
	public Double convertCurrency(@RequestBody ConvertCurrency Currency) {
		return convertCurrencyService.convertCurrency(Currency);
	}
}
