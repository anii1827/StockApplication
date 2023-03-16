package com.stockmarket.company.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stockmarket.company.model.CompanyCommandDto;
import com.stockmarket.company.model.CompanyPriceDto;

public interface CompanyCommandService {

	void registerTheCompany(CompanyCommandDto company) throws JsonProcessingException;
	
	void deleteTheCompany(String companyCode) throws JsonProcessingException;
	
	void updateThePrice(CompanyPriceDto companyPrice) throws JsonProcessingException;

}
