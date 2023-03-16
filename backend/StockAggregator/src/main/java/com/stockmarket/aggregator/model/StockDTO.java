package com.stockmarket.aggregator.model;

import java.time.LocalDateTime;

public class StockDTO {
		private double price;
		private LocalDateTime startTime;
		private LocalDateTime endTime;
		private String companyCode;
		public StockDTO() {
			
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public LocalDateTime getStartTime() {
			return startTime;
		}
		public void setStartTime(LocalDateTime startTime) {
			this.startTime = startTime;
		}
		public LocalDateTime getEndTime() {
			return endTime;
		}
		public void setEndTime(LocalDateTime endTime) {
			this.endTime = endTime;
		}
		public String getCompanyCode() {
			return companyCode;
		}
		public void setCompanyCode(String companyCode) {
			this.companyCode = companyCode;
		}
		@Override
		public String toString() {
			return "StockDTO [price=" + price + ", startTime=" + startTime + ", endTime=" + endTime + ", companyCode="
					+ companyCode + "]";
		}
		
		
		
}
