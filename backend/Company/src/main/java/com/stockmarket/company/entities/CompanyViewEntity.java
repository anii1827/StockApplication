package com.stockmarket.company.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

@Entity(name = "viewcompany")
@Immutable
public class CompanyViewEntity {
	public CompanyViewEntity() {
	}
	
	@Id
	private Long id;
	
	
	private String companyCode;
	
	
	private String companyName;
	
	
	private String companyCEO;
	
	
	private String turnOver;
	
	
	private String companyWebsite;

	
	
	public Long getId() {
		return id;
	}



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



	@Override
	public String toString() {
		return "CompanyEntity [id=" + id + ", companyCode=" + companyCode + ", companyName=" + companyName
				+ ", companyCEO=" + companyCEO + ", turnOver=" + turnOver + ", companyWebsite=" + companyWebsite + "]";
	}

}
