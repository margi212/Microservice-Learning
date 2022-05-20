package com.ibm.common.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.validation.FieldError;

public class ErrorDetails {
	public ErrorDetails() {
		// TODO Auto-generated constructor stub
	}

	private String errorCode;
	private String errorDetails;
	private LocalDateTime timestamp;
	private List<FieldError> errorFields;

	public String getErrorCode() {
		return errorCode;
	}

	public List<FieldError> getErrorFields() {
		return errorFields;
	}

	public void setErrorFields(List<FieldError> errors) {
		this.errorFields = errors;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public ErrorDetails(String errorCode, String errorDetails, LocalDateTime timestamp) {
		super();
		this.errorCode = errorCode;
		this.errorDetails = errorDetails;
		this.timestamp = timestamp;
	}

}
