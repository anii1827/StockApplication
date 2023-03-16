package com.stockmarket.stock.service;

import java.util.List;

import com.stockmarket.stock.model.StockDTO;
import com.stockmarket.stock.model.StockStatsDTO;

public interface StockQueryService {
		
		public StockDTO getStockDetails(String Companycode);
		
		public StockStatsDTO getStockDetails(String Companycode, String startDate, String endDate);
		
		public List<StockDTO> getAllStockLatestDetails();
		
}
