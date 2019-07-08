/*
 *  @(#)DefaultExceptionResponse.java
 * 
 * handles response for all the exceptions in code
 */
package com.byndr.boot.exceptionhandling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * handles response for all the exceptions in code
 * @author RAHUL
 * @category exception handler
 *
 */
@ControllerAdvice
public class DefaultExceptionResponse extends ResponseEntityExceptionHandler {

	/**
	 * @param exception
	 * @return Response ErrorMsg object when Exception occured
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ModelResponse> gotWrong(Exception  exception){
		
		ModelResponse exResponse = new ModelResponse(exception.getMessage(),
										"Some thing error occured on server");
		return new ResponseEntity<>(exResponse,new HttpHeaders(),
										HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

/**
 * @author RAHUL
 * @category ModelResponse object with message and details simple model object
 *
 */
class ModelResponse{
	String message;
	
	String details;
	
	public ModelResponse() {
		super();
	}
	public ModelResponse(String message, String details) {
		super();
		this.message = message;
		this.details = details;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
