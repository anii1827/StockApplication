package com.stockmarket.aggregator.model;

public class StockCompany {
	
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

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}

	public void setTurnOver(String turnOver) {
		this.turnOver = turnOver;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "StockCompany [companyCode=" + companyCode + ", companyName=" + companyName + ", companyCEO="
				+ companyCEO + ", turnOver=" + turnOver + ", companyWebsite=" + companyWebsite + ", price=" + price
				+ "]";
	}
	
	
	
}
