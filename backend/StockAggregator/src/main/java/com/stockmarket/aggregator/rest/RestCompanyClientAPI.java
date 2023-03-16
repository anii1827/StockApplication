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
import com.stockmarket.aggregator.model.CompanyQueryDTO;


@Service
public class RestCompanyClientAPI {
	
		@Value("${company.url}")
		public String comapnyBaseUrl;
	
		@Value("${company.service.name}")
		public String applicationName;
		
		@Autowired
		RestTemplate restTemplate;
		
		@Autowired
		URLConfig urlconfig;
		
		public RestCompanyClientAPI(RestTemplate restTemplate) {
			this.restTemplate = restTemplate;
		}
	
		public CompanyQueryDTO getCompanyDetails(String CompanyCode){
//			String companyURL = urlconfig.getUrl(applicationName, comapnyBaseUrl);
			
			String url = UriComponentsBuilder.fromHttpUrl(comapnyBaseUrl+"/infoByCompany").
					queryParam("company", "{company}").encode().toUriString();
					HashMap<String, String> map = new HashMap<>();
//					System.out.println(url);
					map.put("company", CompanyCode);
					
					return restTemplate.getForObject(url, CompanyQueryDTO.class, map);
		}
		
		public List<CompanyQueryDTO> getAllCompanyDetails(){
//			String companyURL = urlconfig.getUrl(applicationName, comapnyBaseUrl);
//			System.out.println(companyURL);
			String url = UriComponentsBuilder.fromHttpUrl(comapnyBaseUrl+"/info").encode().toUriString();
//			System.out.println(url);
			CompanyQueryDTO[] companies = restTemplate.getForObject(url, CompanyQueryDTO[].class);
			return Arrays.asList(companies);
		}

}
