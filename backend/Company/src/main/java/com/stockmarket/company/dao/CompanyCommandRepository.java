package com.stockmarket.company.dao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stockmarket.company.entities.CompanyEntity;

@Repository
public interface CompanyCommandRepository extends CrudRepository<CompanyEntity, Long> {

		@Modifying
		@Query(value = "Delete FROM CompanyEntity where companyCode=?1")
		void delete(String companyCode);
		
}
