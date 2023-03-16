package com.stockmarket.aggregator.model;

public class CompanyQueryDTO {
	
	private String companyCode;

	private String companyName;
	
	private String companyCEO;
	
	private String turnOver;
	
	private String companyWebsite;

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCEO() {
		return companyCEO;
	}

	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}

	public String getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(String turnOver) {
		this.turnOver = turnOver;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public CompanyQueryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CompanyQueryDTO [companyCode=" + companyCode + ", companyName=" + companyName + ", companyCEO="
				+ companyCEO + ", turnOver=" + turnOver + ", companyWebsite=" + companyWebsite + "]";
	}

	
	
}
