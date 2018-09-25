package com.bigdataconcept.microservice.event.creditBureau;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.bigdataconcept.microservice.event.amqp.adapter.consumer.AmqpRpcServer;

@SpringBootApplication
@ComponentScan("com.bigdataconcept.microservice.event.creditBureau,com.bigdataconcept.microservice.event.amqp.adapter.consumer")
public class CreditBureauServiceApplication {
	public static void main(String[] args) {
	    ApplicationContext app =	SpringApplication.run(CreditBureauServiceApplication.class, args);
	   System.out.println(app.getBean("bindings"));
		
	}
}
