package com.stockmarket.gatway.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import com.stockmarket.gatway.filter.StockGatwayFilter;

@Configuration
public class StockGatwayConfig {

	@Autowired
	StockGatwayFilter filter;
	
	@Value("${aggregatorService}")
	private String aggregator_service;
	
	@Value("${authService}")
	private String auth_service;
	
	@Value("${stockService}")
	private String stock_service;
	
	@Value("${companyService}")
	private String company_service;
	
	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("StockAggregator", r->r.path("/api/v1.0/market/information/**").filters(f->f.filter(filter)).uri(aggregator_service))
				.route("Authentication", r->r.path("/api/v1.0/market/auth/**").filters(f->f.filter(filter)).uri(auth_service))
				.route("Stock", r->r.path("/api/v1.0/market/stock/**").filters(f->f.filter(filter)).uri(stock_service))
				.route("Company", r->r.path("/api/v1.0/market/company/**").filters(f->f.filter(filter)).uri(company_service))
				.build();
	} 
	
	@Bean
    public CorsWebFilter corsWebFilter() {

        final CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Collections.singletonList("*"));
        corsConfig.setMaxAge(3600L);
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST","PUT","DELETE"));
        corsConfig.addAllowedHeader("*");

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }  
	
}
