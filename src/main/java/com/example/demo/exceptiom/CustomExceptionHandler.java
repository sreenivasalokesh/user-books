package com.example.demo.exceptiom;

import org.apache.tomcat.util.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {


	
	@ExceptionHandler (value = Exception.class)
	public ResponseEntity<Object> exception(Exception exception) {
		if(exception instanceof BaseException) {
			return new ResponseEntity<Object>(((BaseException)exception).getErrorObject(), HttpStatus.NOT_FOUND); 
		}
		
		return new ResponseEntity<Object>(new CustomErrorObject("UNKNOWN_ERROR", exception.getMessage(), org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace(exception)), HttpStatus.NOT_FOUND); 
	}
	
}
