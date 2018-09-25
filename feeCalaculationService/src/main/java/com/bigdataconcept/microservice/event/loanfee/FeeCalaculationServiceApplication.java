package com.bigdataconcept.microservice.event.loanfee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bigdataconcept.microservice.event.loanfee,com.bigdataconcept.microservice.event.amqp.adapter.consumer")
public class FeeCalaculationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeeCalaculationServiceApplication.class, args);
	}
}
