package com.bigdataconcept.microservice.event.amqp.adapter.producer;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bigdataconcept.microservice.event.common.message.payload.MessageRequest;

public class AmqpPublisher {

       Logger logger = Logger.getLogger(AmqpPublisher.class);
    
        @Autowired
	private RabbitTemplate template;

	@Autowired
	private TopicExchange pubExchange;

	public void publishEvent(MessageRequest request) {
	    logger.info(String.format("Exchange: %s ", pubExchange));
	    logger.info(String.format("Service Request: {}", request));
	    String routingKey = request.getServiceName() + "." + request.getServiceAction();

		ObjectMapper mapper = new ObjectMapper();
		
		String jsonMessage = "";
		
		try {
		     jsonMessage = mapper.writeValueAsString(request);
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    
	    template.convertAndSend(pubExchange.getName(), routingKey, jsonMessage);
	}

	
}
