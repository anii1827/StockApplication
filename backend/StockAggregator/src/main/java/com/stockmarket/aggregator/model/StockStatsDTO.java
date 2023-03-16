package com.stockmarket.aggregator.model;

import java.util.List;

public class StockStatsDTO{
	private double max;
	private double min;
	private double average;
	private double price;
	private List<StockDTO> stocks;
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public List<StockDTO> getStocks() {
		return stocks;
	}
	public void setStocks(List<StockDTO> stocks) {
		this.stocks = stocks;
	}
	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "StockStatsDTO [max=" + max + ", min=" + min + ", average=" + average + ", price=" + price + ", stocks="
				+ stocks + "]";
	}
	
	
}
