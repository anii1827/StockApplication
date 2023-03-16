package com.stockmarket.aggregator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.stockmarket.aggregator.config.RestTemplateConfiguration;
import com.stockmarket.aggregator.config.URLConfig;
import com.stockmarket.aggregator.model.StockDTO;
import com.stockmarket.aggregator.model.StockStatsDTO;
import com.stockmarket.aggregator.rest.RestCompanyClientAPI;
import com.stockmarket.aggregator.rest.RestStockClientAPI;
import com.stockmarket.aggregator.service.StockCompanyService;
import com.stockmarket.aggregator.service.Impl.StockCompanyServiceImpl;


@SpringBootTest
class StockAggregatorApplicationTests {

	@Autowired
	URLConfig config;
	
	RestStockClientAPI stockApi = new RestStockClientAPI(new RestTemplateConfiguration().getRestTemplate());
	RestCompanyClientAPI companyApi = new RestCompanyClientAPI(new RestTemplateConfiguration().getRestTemplate());
	StockCompanyService service = new StockCompanyServiceImpl(companyApi, stockApi);
	

	
	@Test
	void contextLoads() {
		stockApi.StockBaseURL = "http://localhost:8081/api/v1.0/market/stock/";
		StockDTO stock = stockApi.getStock("xyz");
		assertEquals("900.0", String.valueOf(stock.getPrice()));
		System.out.println(stock);
	}

	@Test 
	void testStockDetailsInTimePeriod() {
		stockApi.StockBaseURL = "api/v1.0/market/stock";
		StockStatsDTO stockDetailsInTimePeriod = stockApi.getStockDetailsInTimePeriod("xyz", "28-07-2022", "29-07-2022");
		System.out.println(stockDetailsInTimePeriod);
		
	}
	
	@Test
	void testAllStockLatestPrice() {
		stockApi.StockBaseURL = "api/v1.0/market/stock";
		stockApi.getAllCompanyLatestStockPrice().stream().forEach(System.out::println);

	}
	
	@Test
	void testSpecificCompanyDetails() {
		companyApi.comapnyBaseUrl = "api/v1.0/market/company";
		System.out.println(companyApi.getCompanyDetails("xyz"));
	}
	
	@Test
	void testAllCompanyDetails() {
		companyApi.comapnyBaseUrl = "api/v1.0/market/company";
		companyApi.getAllCompanyDetails().stream().forEach(System.out::println);
	}
	
	@Test()
	void testTheServiceLevelMethod() {
		stockApi.StockBaseURL = "api/v1.0/market/stock";
		companyApi.comapnyBaseUrl = "api/v1.0/market/company";
		service.getCompanyDetailsInTimePeriod("xyz", "28-07-2022", "29-07-2022");
		System.out.println();
		service.getAllCompanies();
		System.out.println();
		System.out.println(service.getCompany("xyz"));
	}
	
	@Test
	void testUrl(){
			String buildUrl = config.buildUrl("127.0.0.1", 8989, "api/v1.0/market/stock");
			System.out.println(buildUrl);
	}
}
