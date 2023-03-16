package com.stockmarket.company.model;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CompanyCommandDto {

	@NotBlank(message = "Company Code should not be Null")
	private String CompanyCode;
	@NotBlank(message = "Company Name should not be Null")
	private String CompanyName;
	@NotBlank(message = "Company CEO Name should not be Null")
	private String CompanyCEO;
	@NotNull(message = "Company Turnover should not be Null")
	@Length(min = 9, message = "Company Turnover should  be greater then 10Cr.")
	private String TurnOver;
	@NotBlank(message = "Company WebSite should not be Null")
	private String CompanyWebsite;
	@Min(value = 1, message = "Initial Stock Price of company should be greater then ZERO")
	private Double InitialPrice;

	public CompanyCommandDto() {
	}

	public String getCompanyCode() {
		return CompanyCode;
	}

	public void setCompanyCode(String companyCode) {
		CompanyCode = companyCode;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getCompanyCEO() {
		return CompanyCEO;
	}

	public void setCompanyCEO(String companyCEO) {
		CompanyCEO = companyCEO;
	}

	public Double getInitialPrice() {
		return InitialPrice;
	}

	public void setInitialPrice(Double initialPrice) {
		InitialPrice = initialPrice;
	}

	public String getTurnOver() {
		return TurnOver;
	}

	public void setTurnOver(String turnOver) {
		TurnOver = turnOver;
	}

	public String getCompanyWebsite() {
		return CompanyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		CompanyWebsite = companyWebsite;
	}

}
