package com.bigdataconcept.microservice.event.loan.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import com.bigdataconcept.microservice.event.loan.processor.dao.LoanApplicationRepository;
import com.bigdataconcept.microservice.event.loan.processor.model.LoanApplication;

@SpringBootApplication
@ComponentScan("com.bigdataconcept.microservice.event.loan.processor")
public class LoanProcessorServiceApplication {

	public static void main(String[] args) {
		ApplicationContext app = SpringApplication.run(LoanProcessorServiceApplication.class, args);
		
		
		    LoanApplicationRepository    loanApplicationRepository = (LoanApplicationRepository) app.getBean("loanApplicationRepository");
		    LoanApplication loan = new LoanApplication();
		    loan.setId("170");
		    loan.setName("Oluwaseyi");
		    loan.setMobileNumber("506-232-8810");
		    loan.setSIN("123-393-3939");
		    loan.setSurname("Otun");
		    loan.setProvince("NB");
		    loan.setCity("Moncton");
		    loan.setPostalCode("E1G-2J3");
		    loan.setAmount(100000.00d);
		    loanApplicationRepository.save(loan);
		    
		    System.out.println(loan.getId());
		    
		
	}
}
