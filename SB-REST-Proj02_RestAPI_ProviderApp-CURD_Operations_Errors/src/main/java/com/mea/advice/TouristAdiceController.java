package com.mea.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mea.model.ErrorDetails;

@RestControllerAdvice
public class TouristAdiceController {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorDetails> handlerIllegalArgException(IllegalArgumentException ile){
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(),ile.getMessage(),502);
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.BAD_REQUEST) ;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handlerAllException(Exception e){
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(),e.getMessage(),500);
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR) ;
	}
}
