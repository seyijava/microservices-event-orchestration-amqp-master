package com.bigdataconcept.microservice.event.amqp.adapter.consumer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;

@Profile({ "amqp-consumer" })
@Configuration
@EnableRabbit 
/**
 * 
 * @author Oluwaseyi Otun 
 * Spring Configuratin for Ampq Consumer
 * 
 *
 */
public class AmqpConsumerConfig {

    
    Logger logger = Logger.getLogger(AmqpConsumerConfig.class);
    
    private Map<String, TopicExchange> exchanegMap = new HashMap<>();
    
   
	@Autowired
	RabbitMqConfig rabbitMqConfig;

	
	
	/**
	 * 
	 * @return 
	 */
	@Bean
	public Queue serviceQueue() {
	    
	    logger.info(String.format("Service Queue Name [%s] ",rabbitMqConfig.getServiceQueueName()));
		return new Queue(rabbitMqConfig.getServiceQueueName());
	}

	@Bean
	public List<TopicExchange> exchanges() {
          List<TopicExchange> exchanges =  Stream.concat(serviceExchanges().stream(), eventExchanges().stream()).collect(Collectors.toList());
          logger.info(String.format("List of Exchanges Name [%s] ",exchanges.toString()));
          return exchanges;
	}

	@Bean
	public List<Binding> bindings() {
	    
	 List<Binding> bindings = Stream.concat(serviceBindings().stream(), eventBindings().stream()).collect(Collectors.toList());
	 logger.info(String.format("List of Binding Name [%s] ",bindings.toString()));
	 return bindings;
	}

	@Bean
	public AmqpRpcServer server() {
	  
	    AmqpRpcServer prc = new AmqpRpcServer();
	  
	    return prc;
	}

	@Bean
	public Queue eventQueue() {
	    
	    
	    logger.info(String.format("Event Queue Name [%s] ",rabbitMqConfig.getEventQueueName()));
	    
		return new Queue(rabbitMqConfig.getEventQueueName());
	}

	@Bean
	public AmqpSubscriber subscriber() {
		return new AmqpSubscriber();
	}

	private List<TopicExchange> serviceExchanges() {
		return rabbitMqConfig.getServiceRoutings().stream().map(rabbitMqConfig::getExchangeName).map(e -> {
			TopicExchange exchange = new TopicExchange(e);
			exchanegMap.put(e, exchange);
			return exchange;
		}).collect(Collectors.toList());
	}

	private List<TopicExchange> eventExchanges() {
		return rabbitMqConfig.getEventRoutings().stream().map(rabbitMqConfig::getExchangeName).map(e -> {
			TopicExchange exchange = new TopicExchange(e);
			exchanegMap.put(e, exchange);
			return exchange;
		}).collect(Collectors.toList());
	}

	private List<Binding> serviceBindings() {
		return rabbitMqConfig
				.getServiceRoutings().stream().map(r -> BindingBuilder.bind(serviceQueue())
						.to(exchanegMap.get(rabbitMqConfig.getExchangeName(r))).with(rabbitMqConfig.getRoutingKey(r)))
				.collect(Collectors.toList());
	}

	private List<Binding> eventBindings() {
		return rabbitMqConfig
				.getEventRoutings().stream().map(r -> BindingBuilder.bind(eventQueue())
						.to(exchanegMap.get(rabbitMqConfig.getExchangeName(r))).with(rabbitMqConfig.getRoutingKey(r)))
				.collect(Collectors.toList());
	}

   
}
