package com.stockmarket.aggregator.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockmarket.aggregator.model.StockCompany;
import com.stockmarket.aggregator.model.StockCompanyStats;
import com.stockmarket.aggregator.service.StockCompanyService;

@RestController
@RequestMapping("/api/v1.0/market/information/")
public class CompanyRequestApi {

	public static final Logger logger = LoggerFactory.getLogger(CompanyRequestApi.class);
	
	@Autowired
	StockCompanyService service;
	
	@GetMapping(value = "/info")
	public ResponseEntity<?> getAllComapnayDetails() {
		logger.info("Stock Company -> retriving all the company details ....");
		List<StockCompany> allCompanies = service.getAllCompanies();
		logger.info("Stock Company -> information has been retrived successfully.");
		return new ResponseEntity<List<StockCompany>>(allCompanies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/infoByCompany", params = {"company"})
	public ResponseEntity<?> getCompanyDetails(@RequestParam(value = "company") String CompanyCode){
		logger.info("Stock Company -> retriving the details for CompanyCode :"+CompanyCode+"....");
		StockCompany company = service.getCompany(CompanyCode);
		logger.info("Stock Company -> information has been retrived successfully.");
		return new ResponseEntity<StockCompany>(company, HttpStatus.OK);
	}
	
	@GetMapping(value = "/infoByStartTime&EndTime", params = {"company","startDate","endDate"})
	public ResponseEntity<?> getStockDetailsInParticularTimePerios(@RequestParam(name = "company") String companycode, @RequestParam(name = "startDate") String startdate, @RequestParam(name = "endDate") String enddate){
		logger.info("Stock Company -> retriving the company and stock details for company Code"+companycode+"....");
		StockCompanyStats companyDetailsInTimePeriod = service.getCompanyDetailsInTimePeriod(companycode, startdate, enddate);
		logger.info("Stock Company -> information has been retrived successfully.");
		return new ResponseEntity<StockCompanyStats>(companyDetailsInTimePeriod, HttpStatus.OK);
	}
}
