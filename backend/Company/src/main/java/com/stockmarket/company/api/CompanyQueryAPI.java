package com.stockmarket.company.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockmarket.company.model.CompanyQueryDTO;
import com.stockmarket.company.service.CompanyQueryService;

@RestController
@RequestMapping("/api/v1.0/market/company/")
public class CompanyQueryAPI {

	public static final Logger logger= LoggerFactory.getLogger(CompanyQueryAPI.class);
	
	@Autowired
	CompanyQueryService  companyQueryService;
	
	@GetMapping(value = "infoByCompany", params = {"company"})
	public CompanyQueryDTO getCompany(@RequestParam(value = "company") String companyCode) {
		logger.info("Company -> getting the company details by company code "+companyCode+"....");
		CompanyQueryDTO companyDetails = companyQueryService.getCompanyDetails(companyCode);
		logger.info("Company -> got the company details succesfully.");
		return companyDetails;
	}
	
	@GetMapping(value = "/info")
	public List<CompanyQueryDTO> getAll() {
		logger.info("Company -> getting all the registered company details ....");
		List<CompanyQueryDTO> allCompany = companyQueryService.getAllCompany();
		logger.info("Company -> got the companies details succesfully.");
		return allCompany;
	}
	
}
