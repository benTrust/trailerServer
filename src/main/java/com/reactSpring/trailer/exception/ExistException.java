package com.reactSpring.trailer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class ExistException extends RuntimeException {
	private static final long serialVersionUID = -1985481488538967647L;
	
	public ExistException(String message) {
		super(message);
	}
}
