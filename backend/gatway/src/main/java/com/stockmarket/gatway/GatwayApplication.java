package com.stockmarket.gatway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableSwagger2
public class GatwayApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GatwayApplication.class, args);
	}
}


