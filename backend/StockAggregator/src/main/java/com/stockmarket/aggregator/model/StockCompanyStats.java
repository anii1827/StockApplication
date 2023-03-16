package com.stockmarket.aggregator.model;

import java.util.List;

public class StockCompanyStats extends StockCompany{
	private double max;
	private double min;
	private double average;
	
	private List<StockDTO> stocks;
	
	public double getMax() {
		return max;
	}
	public double getMin() {
		return min;
	}
	public double getAverage() {
		return average;
	}
	public List<StockDTO> getStocks() {
		return stocks;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public void setStocks(List<StockDTO> stocks) {
		this.stocks = stocks;
	}
	@Override
	public String toString() {
		return "StockCompanyStats [max=" + max + ", min=" + min + ", average=" + average + ", stocks=" + stocks
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
