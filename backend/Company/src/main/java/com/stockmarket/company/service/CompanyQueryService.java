package com.stockmarket.company.service;

import java.util.List;

import com.stockmarket.company.model.CompanyQueryDTO;

public interface CompanyQueryService {
		public CompanyQueryDTO getCompanyDetails(String companyCode);
		
		public List<CompanyQueryDTO> getAllCompany();
}
