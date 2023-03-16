package com.stockmarket.stock.model;

import java.util.List;

public class StockStatsDTOBuilder {
	List<StockDTO> list;
	private double max;
	private double min;
	private double average;
	
	
	public List<StockDTO> getList() {
		return list;
	}
	public StockStatsDTOBuilder setList(List<StockDTO> list) {
		this.list = list;
		return this;
	}
	public double getMax() {
		return max;
	}
	public StockStatsDTOBuilder setMax(double max) {
		this.max = max;
		return this;
	}
	public double getMin() {
		return min;
	}
	public StockStatsDTOBuilder setMin(double min) {
		this.min = min;
		return this;
	}
	public double getAverage() {
		return average;
	}
	public StockStatsDTOBuilder setAverage(double average) {
		this.average = average;
		return this;
	}
	
	public StockStatsDTO build() {
		StockStatsDTO dto = new StockStatsDTO();
		dto.setMax(this.getMax());
		dto.setMin(this.getMin());
		dto.setAverage(this.getAverage());
		dto.setStocks(this.getList());
		return dto;
	}
}
