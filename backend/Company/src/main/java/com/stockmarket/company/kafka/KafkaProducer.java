package com.stockmarket.company.kafka;

import org.springframework.kafka.core.KafkaTemplate;

public abstract class KafkaProducer<K, V> {
		
	protected KafkaTemplate<K, V> kafkaTemplate;
	
	public abstract void sendMessgage(V Message);
	
}
