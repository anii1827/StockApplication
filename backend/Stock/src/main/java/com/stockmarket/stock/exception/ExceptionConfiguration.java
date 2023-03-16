package com.stockmarket.stock.exception;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfiguration {

	@Autowired
	Logger logger;
	
	@ExceptionHandler(StockException.class)
	public ResponseEntity<?> handleStockExcption(StockException ex){
			logger.error(ex.getMessage());
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_ACCEPTABLE);
	}
	
}
