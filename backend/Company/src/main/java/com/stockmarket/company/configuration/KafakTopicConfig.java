package com.stockmarket.company.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafakTopicConfig {

	@Value("${stock.kafka.topic.registercompany}")
	private String Cregister;
	
	@Value("${stock.kafka.topic.removecompany}")
	private String Cremove;
	
	
	@Bean
	public NewTopic newCompanyRegistered() {
		return TopicBuilder.name(Cregister).build();
	}
	
	@Bean
	public NewTopic deleteCompany() {
		return TopicBuilder.name(Cremove).build();
	}

}
