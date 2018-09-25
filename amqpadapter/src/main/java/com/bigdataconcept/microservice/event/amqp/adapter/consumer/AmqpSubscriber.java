package com.bigdataconcept.microservice.event.amqp.adapter.consumer;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.bigdataconcept.microservice.event.common.message.payload.MessageRequest;
import com.bigdataconcept.microservice.event.common.service.ServiceHandler;

public class AmqpSubscriber {

    
      static Logger logger =  Logger.getLogger(AmqpSubscriber.class);
    
        @Autowired
	ServiceHandler serviceHandler;

	@RabbitListener(queues = "#{eventQueue.name}")
	public void process(String request) {
	        logger.info(String.format("Subscribed event: {}", request));
	        logger.info(String.format("Handled by: %s ", serviceHandler.getClass()));
	        serviceHandler.processMessageRequestAsync(request);
	}
}
