package com.stockmarket.company;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockmarket.company.dao.CompanyCommandRepository;
import com.stockmarket.company.entities.CompanyEntity;
import com.stockmarket.company.kafka.KafkaCreateCompanyProducer;
import com.stockmarket.company.kafka.KafkaProducer;
import com.stockmarket.company.model.CompanyCommandDto;
import com.stockmarket.company.model.CompanyQueryDTO;
import com.stockmarket.company.service.CompanyCommandService;
import com.stockmarket.company.service.CompanyQueryService;

@SpringBootTest
class DemoApplicationTests {

	  @Autowired
	  WebApplicationContext webApplicationContext; 
	
	  @Autowired
	  CompanyCommandRepository repo;
	  
	  @Autowired
	  CompanyCommandService service;
	  
	  @Autowired
	  CompanyQueryService query;
	  
	  @Autowired
	  KafkaCreateCompanyProducer kafka;
	  
	  
	  
	@Test
	void registerApiTest() throws Exception {
		//all fields should have value
		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		CompanyCommandDto c = new CompanyCommandDto();
		String writeValueAsString = new ObjectMapper().writeValueAsString(c);
		MvcResult andReturn = mvc.perform(MockMvcRequestBuilders.post("/api/v1.0/market/company/register")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(writeValueAsString)).andReturn();
		System.out.println(andReturn.getResponse().getContentAsString());
		
		System.out.println();
		//company turnover less then 10Cr
		c.setCompanyCEO("skjdflsd");
		c.setCompanyCode("sdfkljsd");
		c.setCompanyName("dsfkjl");
		c.setCompanyWebsite("sdlfjds");
		c.setTurnOver("10");
		
		 writeValueAsString = new ObjectMapper().writeValueAsString(c);
		 andReturn = mvc.perform(MockMvcRequestBuilders.post("/api/v1.0/market/company/register")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(writeValueAsString)).andReturn();
		System.out.println(andReturn.getResponse().getContentAsString());
		
		System.out.println();
		
		//all field have value and turn over greater then 10cr
		c.setCompanyCEO("Anil");
		c.setCompanyCode("123");
		c.setCompanyName("mahiDigitalTechnologySolutions");
		c.setCompanyWebsite("Mahi.com");
		c.setTurnOver("200000000");
		
		
		 writeValueAsString = new ObjectMapper().writeValueAsString(c);
		 andReturn = mvc.perform(MockMvcRequestBuilders.post("/api/v1.0/market/company/register")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(writeValueAsString)).andReturn();
		System.out.println(andReturn.getResponse().getContentAsString());
	}
	
	@Test
	void TestRetrivingApis() throws Exception {
		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		MvcResult andReturn = mvc.perform(MockMvcRequestBuilders.get("/api/v1.0/market/company/info/xyz")).andReturn();
		String contentAsString = andReturn.getResponse().getContentAsString();
		System.out.println(contentAsString);
		
		MvcResult andReturn2 = mvc.perform(MockMvcRequestBuilders.get("/api/v1.0/market/company/info")).andReturn();
		String contentAsString2 = andReturn2.getResponse().getContentAsString();
		System.out.println(contentAsString2);
		
	}
	
	@Test
	void deleteApiTest() throws Exception {
		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		mvc.perform(MockMvcRequestBuilders.delete("/api/v1.0/market/company/delete/123")
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
	
	}
	
//	@Test
//	void deleteRepoRest() {
//		service.deleteTheCompany("sdfkljsd");
//	}
	
	@Test
	void conversion() throws Exception {
		CompanyCommandDto c = new CompanyCommandDto();
		c.setCompanyCEO("skjdflsd");
		c.setCompanyCode("sdfkljsd");
		c.setCompanyName("dsfkjl");
		c.setCompanyWebsite("sdlfjds");
		c.setTurnOver("100000000");
		CompanyEntity entity = new CompanyEntity();
		BeanUtils.copyProperties(c, entity);
		System.out.println(entity);
		repo.save(entity);
	}
	
	@Test
	void getCompanyDetailsByCompanyCode(){
		CompanyQueryDTO companyDetails = query.getCompanyDetails("xyz");
		System.out.println(companyDetails);
		Assert.isTrue("Anil".equals(companyDetails.getCompanyCEO()));
	}
	 
	
	@Test
	void getAllCompanies() {
		List<CompanyQueryDTO> allCompany = query.getAllCompany();
		Assert.notNull(allCompany);
		Assert.isTrue(allCompany.size()==2);
		System.out.println(allCompany);
	}
	
	@Test
	void KafkaCreateCompanyTopic() {
		CompanyCommandDto c = new CompanyCommandDto();
		c.setCompanyCEO("skjdflsd");
		c.setCompanyCode("sdfkljsd");
		c.setCompanyName("dsfkjl");
		c.setCompanyWebsite("sdlfjds");
		c.setTurnOver("100000000");
		c.setInitialPrice(100.0);
		
	}
	
	

}
