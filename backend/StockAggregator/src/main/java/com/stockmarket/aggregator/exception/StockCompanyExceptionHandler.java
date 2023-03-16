package com.stockmarket.aggregator.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StockCompanyExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(StockCompanyExceptionHandler.class);
	
	@ExceptionHandler(customStockException.class)
	public ResponseEntity<?> customExceptionHandler(customStockException ex){
		logger.error(ex.getMessage());
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> mainExceptionHandler(Exception ex){
		logger.error(ex.getMessage());
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
