package com.reactSpring.trailer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException  extends RuntimeException{
	private static final long serialVersionUID = 5250084266307331576L;

	public BadRequestException(String message) {
		super(message);
	}
}