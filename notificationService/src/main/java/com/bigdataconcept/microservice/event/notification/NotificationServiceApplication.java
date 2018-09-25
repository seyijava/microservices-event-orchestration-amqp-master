package com.bigdataconcept.microservice.event.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.bigdataconcept.microservice.event.amqp.adapter.consumer.AmqpRpcServer;


@SpringBootApplication
@ComponentScan("com.bigdataconcept.microservice.event")
public class NotificationServiceApplication {

	public static void main(String[] args) {
		
		  ApplicationContext app =	SpringApplication.run(NotificationServiceApplication.class, args);
		  
		  
	}
}
