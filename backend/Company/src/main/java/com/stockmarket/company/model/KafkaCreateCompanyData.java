package com.stockmarket.company.model;

import java.io.Serializable;

public class KafkaCreateCompanyData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7032482301874304841L;


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
