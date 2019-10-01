package br.com.leandro.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.leandro.kafka.models.SimpleModel;

@Component
public class KafkaConsumer {

	@KafkaListener(topics = "myTopic")
	public void consumerKafka(SimpleModel model) {
		System.out.println("Consumindo model: " + model.toString());
	}
}
