package com.stockmarket.stock.dao;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stockmarket.stock.entities.StockViewEntity;

@Repository
public interface StockViewRepository extends ReadOnlyRepository<StockViewEntity, Long> {
	 
	@Query(value = "SELECT s FROM viewstock s where companyCode=?1 and endTime IS NULL")
	public StockViewEntity getLatestStock(String CompanyCode);

	
	@Query(value = "SELECT s FROM viewstock s where companyCode=?1")
	public List<StockViewEntity> getStock(String CompanyCode);
	
	
	default public List<StockViewEntity> getSpecificLatestStock(List<String> companyCodes) {
		List<StockViewEntity> list = new LinkedList<>();
		for(String companyCode : companyCodes) {
			list.add(getLatestStock(companyCode));
		}
		return list;
	}
	
	@Query(value = "SELECT s FROM viewstock s where endTime IS NULL")
	public List<StockViewEntity> getAllLatestStock();
	
	
	@Query(value = "SELECT s FROM viewstock s WHERE companyCode=?1 and startTime>=?2 and endTime<=?3")
	public List<StockViewEntity> getStockPriceInSpecficTimePeriod(String companyCode, LocalDateTime startTime, LocalDateTime endTime);
	
}