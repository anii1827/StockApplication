package com.stockmarket.stock.api;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.stockmarket.stock.model.Response;
import com.stockmarket.stock.service.StockCommandService;


@RestController
@RequestMapping("/api/v1.0/market/stock/")
public class StockCommandAPI {
	
		@Autowired
		private Logger logger;
	
		@Autowired
		private StockCommandService stockCommandService;
	
		@PostMapping("/add/{companyCode}")
		public ResponseEntity<?> addStock(@PathVariable String companyCode, @RequestBody ObjectNode stockPrice)  {
			Double price = Double.valueOf(stockPrice.get("Price").asText());
			logger.info("adding stock price details in database for companyCode "+ companyCode+" share price "+stockPrice+"....");
			stockCommandService.addStock(companyCode, price);
			logger.info("Stock price Added Succesfully for companyCode "+ companyCode+" share price "+stockPrice);
			return new ResponseEntity<String>("Stock Price Added Succesfully for companyCode "+ companyCode+" share price "+stockPrice, HttpStatus.OK);
		}
		
		@DeleteMapping("/delete/{companyCode}")
		public ResponseEntity<?>  deleteStocks(@PathVariable String companyCode) {
			logger.info("deleting the stock for the company code.... "+ companyCode);
			stockCommandService.deleteStock(companyCode);
			logger.info("stock has been deleted for the company code "+ companyCode);
			return new ResponseEntity<String>("stock has been deleted for the company code "+ companyCode, HttpStatus.OK);
		}
		
}
