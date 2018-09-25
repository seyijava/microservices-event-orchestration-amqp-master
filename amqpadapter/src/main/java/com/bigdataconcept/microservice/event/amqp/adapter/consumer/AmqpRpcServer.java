package com.bigdataconcept.microservice.event.amqp.adapter.consumer;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bigdataconcept.microservice.event.common.message.payload.MessageRequest;
import com.bigdataconcept.microservice.event.common.message.payload.MessageResponse;
import com.bigdataconcept.microservice.event.common.service.ServiceHandler;


/**
 * 
 * @author Otun oluwaseyi
 * RPC Message Listener.It pick up 
 * a message from the queue to it via the 
 * TopicExchange and invoke the Service Handler
 * Each Microservice Implements the Service Handler and processs
 * the message and return back to client rpc adapter
 *
 */

public class AmqpRpcServer {

    
    
       static Logger logger = Logger.getLogger(AmqpRpcServer.class);
    
        @Autowired
	ServiceHandler serviceHandler;

	@RabbitListener(queues = "#{serviceQueue.name}")
	public MessageResponse process(String request) {
	    
	    System.out.println("\n\n\n" +serviceHandler.getClass() );
	    logger.info(String.format("RPC service request: %s", request));
	    logger.info(String.format("Handled by: %s", serviceHandler.getClass()));
	    return serviceHandler.processMessageRequestSync(request);
	}
}
