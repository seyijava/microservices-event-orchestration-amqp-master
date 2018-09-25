package com.bigdataconcept.microservice.event.amqp.adapter.producer;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

@Profile({ "amqp-producer" })
@Configuration
public class AmqpProducerConfig {
	
    
       @Value("${spring.rabbitmq.exchange.rpc}")
	private String exchangeRpc;

	@Value("${spring.rabbitmq.exchange.pub}")
	public String exchangePub;

	@Bean
	public TopicExchange rpcExchange() {
		return new TopicExchange(exchangeRpc);
	}

	@Bean
	public AmqpRpcClient rpcClient() {
		return new AmqpRpcClient();
	}

	@Bean
	public TopicExchange pubExchange() {
		return new TopicExchange(exchangePub);
	}

	@Bean
	public AmqpPublisher pubClient() {
	      System.out.println("I am here ooo\n\n");
		return new AmqpPublisher();

	}
	
	
	
	 @Bean  
	    public ConnectionFactory connectionFactory() {  
	          CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
	          connectionFactory.setHost("127.0.0.1");
	          connectionFactory.setPort(5672);
	          connectionFactory.setVirtualHost("eventBus");
	          connectionFactory.setUsername("admin");
	          connectionFactory.setPassword("password");
	          connectionFactory.setPublisherConfirms(true); 
	          return connectionFactory;
	    } 

	    @Bean
	    public RabbitTemplate rabbitTemplate() {
	        RabbitTemplate template = new RabbitTemplate(connectionFactory());
	        
	        return template;
	    }
	 
	 
	/*@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}*/

}