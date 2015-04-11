package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Requested entity does not exist")
public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 7803302015601653764L;
}
