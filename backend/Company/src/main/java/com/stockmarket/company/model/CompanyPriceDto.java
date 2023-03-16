package com.stockmarket.company.model;

import javax.validation.constraints.Pattern;

public class CompanyPriceDto {

		private String CompanyCode;
		private String Price;
		
		public String getCompanyCode() {
			return CompanyCode;
		}
		public String getPrice() {
			return Price;
		}
		public void setCompanyCode(String companyCode) {
			CompanyCode = companyCode;
		}
		public void setPrice(String price) {
			Price = price;
		}
		
		@Override
		public String toString() {
			return "CompanyPriceDto [CompanyCode=" + CompanyCode + ", Price=" + Price + "]";
		}		
}
