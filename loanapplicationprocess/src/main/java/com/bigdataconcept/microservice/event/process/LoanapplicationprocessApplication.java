package com.bigdataconcept.microservice.event.process;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableProcessApplication
@ComponentScan("com.bigdataconcept.microservice.event.amqp.adapter.producer,com.bigdataconcept.microservice.event.bpmn.loan,com.bigdataconcept.microservice.event.process")
public class LoanapplicationprocessApplication {

	public static void main(String[] args) {
		ApplicationContext app = SpringApplication.run(LoanapplicationprocessApplication.class, args);
		
		
		RabbitTemplate rabbitTemplate = (RabbitTemplate)app.getBean("rabbitTemplate");
		
		 rabbitTemplate.convertAndSend("loan.rpc", "CreditBureauService","hello world");
	}
	
	
	
	
	
}
