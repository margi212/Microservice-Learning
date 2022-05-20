package com.ibm.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ibm.common.exceptions.ErrorDetails;
import com.ibm.common.exceptions.CurrencyNotFoundException;

@RestControllerAdvice
public class CurrencyControllerAdvice {

	@ExceptionHandler(CurrencyNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorDetails> handleCurrencyNotFound(CurrencyNotFoundException e) {
		ErrorDetails ed = new ErrorDetails("Currency-404", "Currency Not Found!", LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ed);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorDetails> handleInvalidCurrency(MethodArgumentNotValidException e) {

		ErrorDetails ed = new ErrorDetails("Currency-400", "Invalid Currency", LocalDateTime.now());
		ed.setErrorFields(e.getFieldErrors());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ed);
	}

}
