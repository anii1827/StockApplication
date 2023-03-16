package com.stockmarket.company.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stockmarket.company.entities.CompanyViewEntity;

@Repository
public interface CompanyQueryRepository extends CompanyReadRepository<CompanyViewEntity, Long>{
		
		@Query("select view from viewcompany view where companyCode=?1")
		Optional<CompanyViewEntity> getCompanyDetails(String CompanyCode);
	
}
