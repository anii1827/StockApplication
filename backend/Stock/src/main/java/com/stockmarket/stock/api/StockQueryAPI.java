package com.stockmarket.stock.api;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockmarket.stock.exception.StockException;
import com.stockmarket.stock.model.StockDTO;
import com.stockmarket.stock.model.StockStatsDTO;
import com.stockmarket.stock.service.StockQueryService;


@RestController
@RequestMapping("/api/v1.0/market/stock/")
public class StockQueryAPI {
	
	@Autowired
	private Logger logger;
	
	@Autowired
	private StockQueryService queryService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/getByCompany", params = {"company"})
	public ResponseEntity<?> getStockDetails(@RequestParam(name = "company") String companycode){
		logger.info("Stock -> retriving the stock details for Company code "+companycode+"....");
		StockDTO stockDetails = queryService.getStockDetails(companycode);
		logger.info("Stock -> retrived the stock details successfully.");
		return new ResponseEntity<StockDTO>(stockDetails, HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/getByCompanyStartDateAndEndDate", params = {"company","startDate","endDate"})
	public ResponseEntity<?> getStockDetailsStartAndEndDate(@RequestParam(name = "company") String companycode, @RequestParam(name = "startDate") String startdate, @RequestParam(name = "endDate") String enddate) throws StockException{
		logger.info("Stock -> retriving all the stock details for Company "+companycode+" from "+startdate+" to "+enddate+"....");
		StockStatsDTO stockDetails = queryService.getStockDetails(companycode, startdate, enddate);
		logger.info("Stock -> retrived all the stock details successfully for Company "+companycode+" from "+startdate+" to "+enddate+".");
		return new ResponseEntity<StockStatsDTO>(stockDetails, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/get")
	public ResponseEntity<?> getAllStockLatestPriceDetails(){
		logger.info("Stock -> retriving all latest stock prices....");
		List<StockDTO> allStockLatestDetails = queryService.getAllStockLatestDetails();
		logger.info("Stock -> retrived all latest stock prices successfully.");
		return new ResponseEntity<List<StockDTO>>(allStockLatestDetails, HttpStatus.OK);
		
	}
}
