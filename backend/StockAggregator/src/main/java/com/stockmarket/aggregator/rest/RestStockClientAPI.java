package com.stockmarket.aggregator.rest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.stockmarket.aggregator.config.URLConfig;
import com.stockmarket.aggregator.model.StockDTO;
import com.stockmarket.aggregator.model.StockStatsDTO;

@Service
public class RestStockClientAPI {

	@Value("${stock.url}")
	public String StockBaseURL;

	@Value("${stock.service.name}")
	public String applicationName;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	URLConfig urlconfig;

	public RestStockClientAPI(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public StockDTO getStock(String CompanyCode) {
		String StockURL = urlconfig.getUrl(applicationName, StockBaseURL);
		String url = UriComponentsBuilder.fromHttpUrl(StockBaseURL + "/getByCompany").queryParam("company", "{company}").encode()
				.toUriString();
//		System.out.println(url);
		HashMap<String, String> map = new HashMap<>();
		map.put("company", CompanyCode);

		return restTemplate.getForObject(url, StockDTO.class, map);
	}

	public StockStatsDTO getStockDetailsInTimePeriod(String companyCode, String startTime, String endTime) {
		String StockURL = urlconfig.getUrl(applicationName, StockBaseURL);
		String url = UriComponentsBuilder.fromHttpUrl(StockBaseURL + "/getByCompanyStartDateAndEndDate").queryParam("company", "{company}")
				.queryParam("startDate", "{startDate}").queryParam("endDate", "{endDate}").encode().toUriString();
//		System.out.println(url);
		HashMap<String, String> map = new HashMap<>();
		map.put("company", companyCode);
		map.put("startDate", startTime);
		map.put("endDate", endTime);

		return restTemplate.getForObject(url, StockStatsDTO.class, map);

	}

	public List<StockDTO> getAllCompanyLatestStockPrice() {
		String StockURL = urlconfig.getUrl(applicationName, StockBaseURL);
//		System.out.println(StockURL);
		String url = UriComponentsBuilder.fromHttpUrl(StockBaseURL + "/get").encode().toUriString();
//		System.out.println(url);
		StockDTO[] stocks = restTemplate.getForObject(url, StockDTO[].class);
		return Arrays.asList(stocks);
	}

}
