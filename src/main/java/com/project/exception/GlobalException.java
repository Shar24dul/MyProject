package com.project.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(Exception.class)
	public String generalException(Exception e){
		return e.getMessage();
	}
}
