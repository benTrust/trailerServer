package com.reactSpring.trailer.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
	private static final long serialVersionUID = 7979755091596300295L;

	public NotFoundException(String message) {
		super(message);
	}
}
