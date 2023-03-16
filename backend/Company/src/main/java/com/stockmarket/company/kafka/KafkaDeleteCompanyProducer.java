package com.stockmarket.company.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stockmarket.company.model.KafkaRemoveCompanyData;

@Service
public class KafkaDeleteCompanyProducer extends KafkaProducer<String, String>{

	@Value("${stock.kafka.topic.removecompany}")
	private String topic;
	
	@Autowired
	public KafkaDeleteCompanyProducer(KafkaTemplate<String, String> template) {
		this.kafkaTemplate = template;
	}
	
	@Override
	public void sendMessgage(String data) {
		this.kafkaTemplate.send(topic, data);
	}

}
