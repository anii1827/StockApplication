package com.stockmarket.company.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaCreateCompanyProducer extends KafkaProducer<String, String>{

	@Value("${stock.kafka.topic.registercompany}")
	private String topic;
	
	@Autowired
	public KafkaCreateCompanyProducer(KafkaTemplate<String, String> template) {
		this.kafkaTemplate = template;
	}
	
	@Override
	public void sendMessgage(String Message) {
		this.kafkaTemplate.send(topic,Message);
	}

}
