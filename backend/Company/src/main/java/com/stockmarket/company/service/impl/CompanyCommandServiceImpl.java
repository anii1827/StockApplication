package com.stockmarket.company.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockmarket.company.dao.CompanyCommandRepository;
import com.stockmarket.company.entities.CompanyEntity;
import com.stockmarket.company.exception.CompanyException;
import com.stockmarket.company.kafka.KafkaCreateCompanyProducer;
import com.stockmarket.company.kafka.KafkaDeleteCompanyProducer;
import com.stockmarket.company.model.CompanyCommandDto;
import com.stockmarket.company.model.CompanyPriceDto;
import com.stockmarket.company.model.CompanyQueryDTO;
import com.stockmarket.company.model.KafkaCreateCompanyData;
import com.stockmarket.company.model.KafkaRemoveCompanyData;
import com.stockmarket.company.service.CompanyCommandService;
import com.stockmarket.company.service.CompanyQueryService;

@Service
public class CompanyCommandServiceImpl implements CompanyCommandService {
	
	private static final Logger logger  = LoggerFactory.getLogger(CompanyCommandServiceImpl.class);

	@Autowired
	CompanyCommandRepository companyCommandRepository;
	
	@Autowired
	KafkaCreateCompanyProducer kafkaCreateProduce;
	
	@Autowired 
	KafkaDeleteCompanyProducer kafkaDeleteProducer;
	
	@Autowired
	CompanyQueryService query;
	
	@Override
	public void registerTheCompany(CompanyCommandDto company) throws JsonProcessingException {	
		CompanyEntity companyEntity = new CompanyEntity();
		BeanUtils.copyProperties(company, companyEntity);
		companyCommandRepository.save(companyEntity);
		sendData(company);
	}

	private void sendData(CompanyCommandDto company) throws JsonProcessingException {
		KafkaCreateCompanyData data = new KafkaCreateCompanyData();
		data.setCompanyCode(company.getCompanyCode());
		data.setPrice(company.getInitialPrice());
		logger.info("Company -> kafka sending data to stock microservice with data "+data+" for register the stocks....");
		kafkaCreateProduce.sendMessgage(new ObjectMapper().writeValueAsString(data));
		logger.info("Company -> kafka send data to stock microservice successfully.");
	}

	@Transactional
	@Override
	public void deleteTheCompany(String companyCode) throws JsonProcessingException {
		companyCommandRepository.delete(companyCode);
		sendData(companyCode);
	}

	private void sendData(String companyCode) throws JsonProcessingException {
		logger.info("Company -> kafka sending companyCode to stock microservice with data:"+companyCode+" for removing the stocks details....");
		KafkaRemoveCompanyData data = new KafkaRemoveCompanyData();
		data.setCompanyCode(companyCode);
		
			kafkaDeleteProducer.sendMessgage(new ObjectMapper().writeValueAsString(data));
			logger.info("Company -> kafka send data to stock microservice for remove the stocks....");
	}

	@Override
	public void updateThePrice(CompanyPriceDto companyPrice) throws JsonProcessingException {
		CompanyQueryDTO companyDetails = query.getCompanyDetails(companyPrice.getCompanyCode());
		
		KafkaCreateCompanyData data = new KafkaCreateCompanyData();
		data.setCompanyCode(companyPrice.getCompanyCode());
		data.setPrice(Double.valueOf(companyPrice.getPrice()));
		
		logger.info("Company -> kafka sending data to stock microservice with data "+data+" for updating the stock price....");
		kafkaCreateProduce.sendMessgage(new ObjectMapper().writeValueAsString(data));
		logger.info("Company -> kafka send data to stock microservice successfully.");
	}
	
	
	
}
