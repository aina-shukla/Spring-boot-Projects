package com.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.exceptions.BookException;
import com.demo.model.ExceptionMessage;

@ControllerAdvice
public class GlobalExceptionHandler {
	
//	@ExceptionHandler(BookException.class)
//	public ResponseEntity<String> bookExceptionHandler(BookException e){
//		return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
//	}

	@ExceptionHandler(BookException.class)
	public ResponseEntity<ExceptionMessage> bookExceptionHandler(BookException e){
		return new ResponseEntity<ExceptionMessage>(
				new ExceptionMessage(500, e.getMessage())
				, HttpStatus.OK);
	}


}
