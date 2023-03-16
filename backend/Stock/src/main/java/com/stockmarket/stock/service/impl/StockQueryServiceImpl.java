package com.stockmarket.stock.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmarket.stock.dao.StockViewRepository;
import com.stockmarket.stock.entities.StockViewEntity;
import com.stockmarket.stock.model.StockDTO;
import com.stockmarket.stock.model.StockStatsDTO;
import com.stockmarket.stock.model.StockStatsDTOBuilder;
import com.stockmarket.stock.service.StockQueryService;
import com.stockmarket.stock.utils.DateUtils;

@Service
public class StockQueryServiceImpl implements StockQueryService{

	@Autowired
	StockViewRepository stockViewRepository;
	
	@Override
	public StockDTO getStockDetails(String Companycode) {
		StockDTO stockDTO = new StockDTO();
		StockViewEntity latestStock = stockViewRepository.getLatestStock(Companycode);
		BeanUtils.copyProperties(latestStock, stockDTO);
		return stockDTO;
	}

	@Override
	public StockStatsDTO getStockDetails(String Companycode, String startDate, String endDate) {
		LocalDateTime startTime = DateUtils.getDate(startDate).atStartOfDay();
		LocalDateTime endTime = DateUtils.getDate(endDate).atStartOfDay().plusHours(24);
		List<StockViewEntity> stockPriceInSpecficTimePeriod = stockViewRepository.getStockPriceInSpecficTimePeriod(Companycode, startTime, endTime);
		
		List<Double> price = new ArrayList<StockViewEntity>(stockPriceInSpecficTimePeriod)
							.stream().
							map(x->x.getPrice()).
							collect(Collectors.toList());
		Hashtable<String, Double> stats = calculateMaxMinAndAverage(price);
		StockStatsDTO stockStatsDto = getStockStatsDto(stockPriceInSpecficTimePeriod, stats);
		stockStatsDto.setPrice(stockViewRepository.getLatestStock(Companycode).getPrice());
		return stockStatsDto;
	}

	
	private StockStatsDTO getStockStatsDto(List<StockViewEntity> stockPriceInSpecficTimePeriod,
			Hashtable<String, Double> stats) {
			return new StockStatsDTOBuilder().setList(getConvertedStock(stockPriceInSpecficTimePeriod))
						.setMax(stats.get("MAX"))
						.setMin(stats.get("MIN"))
						.setAverage(stats.get("AVG"))
						.build();
	}
	

	@Override
	public List<StockDTO> getAllStockLatestDetails() {
		List<StockViewEntity> allLatestStock = stockViewRepository.getAllLatestStock();
		return getConvertedStock(allLatestStock);
	}
	
	private List<StockDTO> getConvertedStock(List<StockViewEntity> list) {
		return list.stream().map(x->{
			StockDTO dto = new StockDTO();
			BeanUtils.copyProperties(x, dto);
			return dto;
		}).collect(Collectors.toList());
		
	}
	
	private Hashtable<String, Double> calculateMaxMinAndAverage(List<Double> price){
		DoubleSummaryStatistics summaryStatistics = price.stream().mapToDouble(Double::doubleValue).summaryStatistics();
		Hashtable<String, Double> stats = new Hashtable<>();
		stats.put("MAX",summaryStatistics.getMax());
		stats.put("MIN",summaryStatistics.getMin());
		stats.put("AVG",summaryStatistics.getAverage());
		return stats;
	}

}
