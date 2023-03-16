package com.stockmarket.aggregator.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmarket.aggregator.model.CompanyQueryDTO;
import com.stockmarket.aggregator.model.StockCompany;
import com.stockmarket.aggregator.model.StockCompanyBuilder;
import com.stockmarket.aggregator.model.StockCompanyStats;
import com.stockmarket.aggregator.model.StockDTO;
import com.stockmarket.aggregator.model.StockStatsDTO;
import com.stockmarket.aggregator.rest.RestCompanyClientAPI;
import com.stockmarket.aggregator.rest.RestStockClientAPI;
import com.stockmarket.aggregator.service.StockCompanyService;

@Service
public class StockCompanyServiceImpl implements StockCompanyService{

	@Autowired
	RestCompanyClientAPI company;
	
	@Autowired 
	RestStockClientAPI stock;
	
	public StockCompanyServiceImpl(RestCompanyClientAPI first, RestStockClientAPI second) {
		this.company = first;
		this.stock = second;
	}
	
	@Override
	public StockCompany getCompany(String companyCode) {
		CompanyQueryDTO companyDetails = company.getCompanyDetails(companyCode);
		StockDTO stockDetails = stock.getStock(companyCode);
		return getData(companyDetails,stockDetails);
	}


	@Override
	public List<StockCompany> getAllCompanies() {
		List<CompanyQueryDTO> allCompanyDetails = company.getAllCompanyDetails();
		Map<String, StockDTO> collect = stock.getAllCompanyLatestStockPrice().stream().collect(Collectors.toMap(x->x.getCompanyCode(), x->x));
		List<StockCompany> res = allCompanyDetails.stream().map(x->{
			return getData(x,collect.get(x.getCompanyCode()));
		}).collect(Collectors.toList());
		res.forEach(System.out::println);
		return res;
	}

	@Override
	public StockCompanyStats getCompanyDetailsInTimePeriod(String companyCode, String startTime, String endtime) {
		StockStatsDTO stockDetailsInTimePeriod = stock.getStockDetailsInTimePeriod(companyCode, startTime, endtime);
		CompanyQueryDTO companyDetails = company.getCompanyDetails(companyCode);
		return getData(companyDetails,stockDetailsInTimePeriod);
		
	}

	
	private StockCompanyStats getData(CompanyQueryDTO companyDetails, StockStatsDTO stockDetailsInTimePeriod) {
		StockCompanyStats dto = new StockCompanyStats();
		BeanUtils.copyProperties(stockDetailsInTimePeriod, dto);
		BeanUtils.copyProperties(companyDetails, dto);
		dto.setPrice(stockDetailsInTimePeriod.getPrice());
		System.out.println(dto);
		return dto;
	}


	private StockCompany getData(CompanyQueryDTO companyDetails, StockDTO stockDetails) {
		return new StockCompanyBuilder().setCompanyCEO(companyDetails.getCompanyCEO())
				.setCompanyCode(companyDetails.getCompanyCode())
				.setCompanyName(companyDetails.getCompanyName())
				.setCompanyWebsite(companyDetails.getCompanyWebsite())
				.setTurnOver(companyDetails.getTurnOver())
				.setPrice(stockDetails.getPrice())
				.build();
	}
	
	


}
