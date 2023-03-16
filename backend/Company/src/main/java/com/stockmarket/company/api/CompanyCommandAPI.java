package com.stockmarket.company.api;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stockmarket.company.model.CompanyCommandDto;
import com.stockmarket.company.model.CompanyPriceDto;
import com.stockmarket.company.service.CompanyCommandService;


@RestController
@RequestMapping("/api/v1.0/market/company/")
public class CompanyCommandAPI {
	
	public static final Logger logger = LoggerFactory.getLogger(CompanyCommandAPI.class);
	
	@Autowired
	CompanyCommandService Cservice;
	
	@PostMapping(path = "register")
	public ResponseEntity<?> registerCompany(@RequestBody @Valid CompanyCommandDto company) throws JsonProcessingException {
		logger.info("Company : "+ company.getCompanyName() +" Registering....");
		Cservice.registerTheCompany(company);
		logger.info("Company : "+ company.getCompanyName() +" Registered.");
		return new ResponseEntity<String>(company.getCompanyName()+" has been Registered Sucessfull.", HttpStatus.CREATED);
	}
	
	@DeleteMapping("delete/{companyCode}")
	public ResponseEntity<?> deleteCompany(@PathVariable(name = "companyCode") String companyCode) throws JsonProcessingException {
		logger.info("Company : "+ "removing the company records having company code "+companyCode+"....");
		Cservice.deleteTheCompany(companyCode);
		logger.info("Company : "+ "the company records have removed having company code "+companyCode);
		return new ResponseEntity<String>("The company records have removed.", HttpStatus.OK);
	}
	
	@PostMapping("updatePrice")
	public ResponseEntity<?> updatePrice(@RequestBody @Valid CompanyPriceDto data) throws JsonProcessingException{
		logger.info("Company : "+ "updating the company Price having companyCode "+data.getCompanyCode()+"....");
		Cservice.updateThePrice(data);
		logger.info("Company : "+ "the company price have updated having company code "+data.getCompanyCode());
		return new ResponseEntity<String>("New Price has been updated.", HttpStatus.OK);
	}
	
}
