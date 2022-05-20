package com.ibm.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ProductNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public ProductNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
