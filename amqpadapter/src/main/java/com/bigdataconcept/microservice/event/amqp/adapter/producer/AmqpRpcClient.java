package com.bigdataconcept.microservice.event.amqp.adapter.producer;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.bigdataconcept.microservice.event.common.message.payload.MessageRequest;
import com.bigdataconcept.microservice.event.common.message.payload.MessageResponse;


/**
 * 
 * @author Oluwaseyi Otun
 * This class model  AmqpRpclient 
 * that send message  to RabbitMQueen Event Bus
 * It is been invoke from Cummuada Orcheration engine
 * to various Microservice adapter listening to event
 * 
 *
 */

public class AmqpRpcClient {

    
    private static final Logger LOG = Logger.getLogger(AmqpRpcClient.class);

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private TopicExchange rpcExchange;

	
	/**
	 * Send Request payload to amqp  Loan.rpc Queue 
	 * via the Service Exchange Adapter 
	 * @param request paylaod 
	 * @return Message Response from Amqp RPC Server
	 */
	public MessageResponse invokeService(MessageRequest request) {
		
	        LOG.info(String.format("Exchange: %s ", rpcExchange));
		
	        LOG.info(String.format(String.format("Service Request: %s", request)));
		
		String routingKey = request.getServiceName() + "." + request.getServiceAction();
		
		LOG.info(String.format("Routing Key: %s ", routingKey));
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonMessage = "";
		
		try {
		     jsonMessage = mapper.writeValueAsString(request);
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	         MessageResponse response = (MessageResponse)rabbitTemplate.convertSendAndReceive(rpcExchange.getName().trim(), routingKey,jsonMessage);
		
		LOG.info(String.format("Service Response: %s ", response));
		return Optional.ofNullable(response).orElse(generateTimedoutResponse(request));
	}

	private MessageResponse generateTimedoutResponse(MessageRequest request) {
	    MessageResponse response =  new MessageResponse();
		return response;
	}
}
