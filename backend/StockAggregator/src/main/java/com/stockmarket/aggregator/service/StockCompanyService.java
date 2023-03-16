package com.stockmarket.aggregator.service;

import java.util.List;

import com.stockmarket.aggregator.model.StockCompany;
import com.stockmarket.aggregator.model.StockCompanyStats;

public interface StockCompanyService {
	
	StockCompany getCompany(String companyCode);
	
	List<StockCompany> getAllCompanies();
	
	StockCompanyStats getCompanyDetailsInTimePeriod(String companyCode, String startTime, String endtime);
}
