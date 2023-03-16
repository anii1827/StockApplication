package com.stockmarket.aggregator.model;

import org.springframework.beans.BeanUtils;

public class StockCompanyBuilder {

	private String companyCode;

	private String companyName;
	
	private String companyCEO;
	
	private String turnOver;
	
	private String companyWebsite;

	private double price;

	public String getCompanyCode() {
		return companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getCompanyCEO() {
		return companyCEO;
	}

	public String getTurnOver() {
		return turnOver;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public double getPrice() {
		return price;
	}

	public StockCompanyBuilder setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
		return this;
	}

	public StockCompanyBuilder setCompanyName(String companyName) {
		this.companyName = companyName;
		return this;
	}

	public StockCompanyBuilder setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
		return this;
	}

	public StockCompanyBuilder setTurnOver(String turnOver) {
		this.turnOver = turnOver;
		return this;
	}

	public StockCompanyBuilder setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
		return this;
	}

	public StockCompanyBuilder setPrice(double price) {
		this.price = price;
		return this;
	}
	
	public StockCompany build() {
		StockCompany stockCompany = new StockCompany();
		BeanUtils.copyProperties(this, stockCompany);
		return stockCompany;
	}
	
	
}
