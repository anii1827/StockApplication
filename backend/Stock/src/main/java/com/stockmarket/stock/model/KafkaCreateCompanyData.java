package com.stockmarket.stock.model;

public class KafkaCreateCompanyData {
	
	public KafkaCreateCompanyData() {
		// TODO Auto-generated constructor stub
	}

	private String companyCode;
	private double price;

	
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "KafkaCreateCompanyData [companyCode=" + companyCode + ", price=" + price + "]";
	}
	
	
	
}
