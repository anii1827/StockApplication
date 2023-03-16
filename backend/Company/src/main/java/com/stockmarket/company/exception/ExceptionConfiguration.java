package com.stockmarket.company.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.stockmarket.company.model.Response;




@ControllerAdvice
public class ExceptionConfiguration {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> exception(MethodArgumentNotValidException args){
		List<String> errors = args.getAllErrors().stream().map(x->x.getDefaultMessage()).collect(Collectors.toList());
		return new ResponseEntity<String>(errors.toString(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CompanyException.class)
	public ResponseEntity<?> exception(CompanyException args){
		return new ResponseEntity<String>(args.getErrorMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exception(Exception args){
		return new ResponseEntity<String>(args.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
}
