package com.stockmarket.stock.model;

public class KafkaRemoveCompanyData {
	
	String CompanyCode;

	public String getCompanyCode() {
		return CompanyCode;
	}

	public void setCompanyCode(String companyCode) {
		CompanyCode = companyCode;
	}
	public KafkaRemoveCompanyData() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "KafkaRemoveCompanyData [CompanyCode=" + CompanyCode + "]";
	}
	
	
}
