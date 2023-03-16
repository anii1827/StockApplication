package com.stockmarket.stock.service;

public interface StockCommandService {
		
		public void deleteStock(String companyCode);
		
		public void addStock(String companyCode, Double stockPrice);
	
}
