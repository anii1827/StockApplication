package com.stockmarket.stock;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.stockmarket.stock.dao.StockViewRepository;
import com.stockmarket.stock.entities.StockViewEntity;
import com.stockmarket.stock.model.StockStatsDTO;
import com.stockmarket.stock.service.StockCommandService;
import com.stockmarket.stock.service.StockQueryService;
import com.stockmarket.stock.service.impl.StockQueryServiceImpl;
import com.stockmarket.stock.utils.DateUtils;

@SpringBootTest
class StockApplicationTests {

	 @Autowired
	  WebApplicationContext webApplicationContext; 
	 
	 @Autowired
	 StockViewRepository repo;
	 
	 @Autowired
	 StockCommandService service;
	
	 @Autowired
	 StockQueryService qservice;
	@Test
	void contextLoads() throws Exception {
		String url = "/api/v1.0/market/stock/";
		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		mvc.perform(MockMvcRequestBuilders.get(url+"get/xyz/28-07-2022/29-07-2022")).andReturn();
		
		System.out.println();
		
		mvc.perform(MockMvcRequestBuilders.get(url+"get/xyz")).andReturn();
		
		System.out.println();
		
		mvc.perform(MockMvcRequestBuilders.get(url+"get")).andReturn();
		
		System.out.println();
		
		String value = "14000";
		mvc.perform(MockMvcRequestBuilders.post(url+"/add/abc")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(value)).andReturn();
		
		System.out.println();
				mvc.perform(MockMvcRequestBuilders.delete(url+"/delete/abc")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(value)).andReturn();
	}
	
	@Test
	void DateUtils() throws Exception {
		DateUtils.getDate("15/08/2022");
	}
	
	@Test 
	void DateCovert(){
		StockQueryServiceImpl query = new StockQueryServiceImpl();
		query.getStockDetails("XYZ", "15/08/2022", "19/08/2022");
	}
	
	
	@Test
	void addSock() {
		service.addStock("xyz", 900.00);
	}
	
	@Test
	public void getLatestStock() {
		StockViewEntity latestStock = repo.getLatestStock("xyz");
		System.out.println(latestStock);
	}
	
	@Test
	public void getSpecificLatestStock() {
		List<String> list = new ArrayList<>();
		list.add("abc");list.add("xyz");
		List<StockViewEntity> allLatestStock = repo.getSpecificLatestStock(list);
		allLatestStock.stream().forEach(System.out::println);
	}
	
	
	@Test
	public void getAllLatestStock() {
		List<StockViewEntity> allLatestStock = repo.getAllLatestStock();
		allLatestStock.stream().forEach(System.out::println);
	}
	
	
	@Test
	public void getStock() {
		repo.getStock("xyz").stream().forEach(System.out::println);
	}
	
	@Test
	public void DeleteStock() {
//		service.deleteStock("abc");
		service.deleteStock("123");
	}
	
	@Test
	public void startTimeEndTime(){
		StockStatsDTO stockDetails = qservice.getStockDetails("xyz", "28/07/2022", "29/07/2022");
		stockDetails.getStocks().forEach(System.out::println);
		System.out.println("MAX = "+stockDetails.getMax());
		System.out.println("MIN = "+stockDetails.getMin());
		System.out.println("AVG = "+stockDetails.getAverage());
	}
	
	@Test
	public void stockExceptionHandle() {
		String url = "/api/v1.0/market/stock/";
		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		try {
			mvc.perform(MockMvcRequestBuilders.get(url+"get/xyz/28.07.2022/29.07.2022")).andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
