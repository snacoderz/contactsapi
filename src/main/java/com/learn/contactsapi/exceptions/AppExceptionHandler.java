package com.learn.contactsapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.learn.contactsapi.model.ErrorResponse;

@ControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(ContactNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleContactNotFound(ContactNotFoundException exception){
		ErrorResponse response = new ErrorResponse("Contact Not found", 404);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}