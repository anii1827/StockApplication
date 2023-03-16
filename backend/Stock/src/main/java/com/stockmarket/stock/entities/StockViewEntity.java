package com.stockmarket.stock.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

@Entity(name = "viewstock")
@Immutable
public class StockViewEntity {
	
	@Id
	private Long id;
	
	private String companyCode;
	
	private double price;
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;
	
	public Long getId() {
		return id;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public double getPrice() {
		return price;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	
	@Override
	public String toString() {
		return "StockViewEntity [id=" + id + ", companyCode=" + companyCode + ", price=" + price + ", startTime="
				+ startTime + ", endTime=" + endTime + "]";
	}
}
