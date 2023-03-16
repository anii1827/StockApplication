package com.stockmarket.stock.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockmarket.stock.model.KafkaCreateCompanyData;
import com.stockmarket.stock.model.KafkaRemoveCompanyData;
import com.stockmarket.stock.service.StockCommandService;

@Service
public class KafkaConsumer {

	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@Autowired
	StockCommandService service;
	
	private final ObjectMapper mapper = new ObjectMapper();
	
	@KafkaListener(groupId = "stockconsumer", topics = "registerCompany")
	void getRegisterData(String data) throws JsonMappingException, JsonProcessingException{
		KafkaCreateCompanyData kafkaCreateCompanyData = mapper.readValue(data, KafkaCreateCompanyData.class);
		logger.info("Stock -> data has been received from kafka broker data : "+data);
//		System.out.println("data -> "+convertValue);
		service.addStock(kafkaCreateCompanyData.getCompanyCode(), kafkaCreateCompanyData.getPrice());
	}
	@KafkaListener(groupId = "stockconsumer", topics = "removeCompany")
	void getRemoveData(String data) throws JsonMappingException, JsonProcessingException{
		KafkaRemoveCompanyData kafkaRemoveCompanyData = mapper.readValue(data, KafkaRemoveCompanyData.class);
		logger.info("Stock -> data has been received from kafka broker data : "+data);
		service.deleteStock(kafkaRemoveCompanyData.getCompanyCode());
	}
}
