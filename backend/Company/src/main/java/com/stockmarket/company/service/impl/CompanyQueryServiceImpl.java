package com.stockmarket.company.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmarket.company.dao.CompanyQueryRepository;
import com.stockmarket.company.entities.CompanyViewEntity;
import com.stockmarket.company.exception.CompanyException;
import com.stockmarket.company.model.CompanyQueryDTO;
import com.stockmarket.company.service.CompanyQueryService;

@Service
public class CompanyQueryServiceImpl implements CompanyQueryService{

	private static final Logger logger  = LoggerFactory.getLogger(CompanyQueryServiceImpl.class);
	
	@Autowired
	CompanyQueryRepository companyQueryRepository;
	
	@Override
	public CompanyQueryDTO getCompanyDetails(String companyCode) {
		Optional<CompanyViewEntity> comp = companyQueryRepository.getCompanyDetails(companyCode);
		try {
			CompanyViewEntity companyDetails = comp.orElseThrow();
			return convertToDto(companyDetails);
		}
		catch(Exception e) {
			logger.error("Company -> No data found for Company with Company Code :"+companyCode+"....");
			throw new CompanyException("No data found for Company with Company Code :"+companyCode);
		}
		
	}

	@Override
	public List<CompanyQueryDTO> getAllCompany() {
		return companyQueryRepository.findAll().stream().map(x->convertToDto(x)).collect(Collectors.toList());
	}
	
	private CompanyQueryDTO convertToDto(CompanyViewEntity companyDetails) {
		CompanyQueryDTO companyQueryDTO = new CompanyQueryDTO();
		BeanUtils.copyProperties(companyDetails,companyQueryDTO);
		return companyQueryDTO;
	}	
}
