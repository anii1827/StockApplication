package com.stockmarket.aggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class StockAggregatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockAggregatorApplication.class, args);
	}
	
}
