package com.stockmarket.stock.config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfiguration {

	@Bean
	public Logger getLogger() {
		return LogManager.getLogger();
	}
	
}
