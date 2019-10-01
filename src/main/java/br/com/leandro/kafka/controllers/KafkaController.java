package br.com.leandro.kafka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leandro.kafka.models.SimpleModel;

@RestController
@RequestMapping("/api/kafka-producer")
public class KafkaController {
	
	private KafkaTemplate<String, SimpleModel> kafkaTemplate;
	
	@Autowired
	public KafkaController(KafkaTemplate<String, SimpleModel> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	@PostMapping
	public void post(@RequestBody SimpleModel model) {
		kafkaTemplate.send("myTopic", model);
	}
}
