package com.stockmarket.stock.service.impl;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmarket.stock.dao.StockWriteRepository;
import com.stockmarket.stock.entities.StockEntity;
import com.stockmarket.stock.service.StockCommandService;

@Service
public class StockCommandServiceImpl implements StockCommandService{

	@Autowired
	StockWriteRepository stockRepository;
	
	@Transactional
	@Override
	public void deleteStock(String companyCode) {
		stockRepository.deleteByCompanyCode(companyCode);
	}

	@Transactional
	@Override
	public void addStock(String companyCode, Double stockPrice) {
		LocalDateTime now = LocalDateTime.now();
		StockEntity previouseStock = stockRepository.getLatestStock(companyCode);
		
		if(previouseStock != null) {
			previouseStock.setEndTime(now);
			stockRepository.save(previouseStock);
		}
		
		StockEntity currentStock = new StockEntity();
		currentStock.setCompanyCode(companyCode);
		currentStock.setPrice(stockPrice);
		currentStock.setStartTime(now);
		stockRepository.save(currentStock);
		
	}

}
