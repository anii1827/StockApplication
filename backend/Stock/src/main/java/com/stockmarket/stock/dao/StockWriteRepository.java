package com.stockmarket.stock.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stockmarket.stock.entities.StockEntity;

@Repository
public interface StockWriteRepository extends CrudRepository<StockEntity, Long> {
			
	 @Query(value = "SELECT s FROM StockEntity s where companyCode=?1 and endTime IS NULL")
	 public StockEntity getLatestStock(String CompanyCode);
	
	 @Modifying
	 @Query(value = "Delete FROM StockEntity where companyCode=?1")
	 public int deleteByCompanyCode(String CompanyCode);
}
