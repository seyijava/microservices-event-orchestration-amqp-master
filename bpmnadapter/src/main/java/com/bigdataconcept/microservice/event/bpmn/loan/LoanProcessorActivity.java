package com.bigdataconcept.microservice.event.bpmn.loan;

import java.util.Date;

import org.apache.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bigdataconcept.microservice.event.amqp.adapter.producer.AmqpRpcClient;
import com.bigdataconcept.microservice.event.common.message.payload.CreditBureauResponse;
import com.bigdataconcept.microservice.event.common.message.payload.DateDeserializer;
import com.bigdataconcept.microservice.event.common.message.payload.LoanApplicationReqeust;
import com.bigdataconcept.microservice.event.common.message.payload.MessageRequest;
import com.bigdataconcept.microservice.event.common.message.payload.MessageResponse;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Component("loanProcessService")
public class LoanProcessorActivity  implements JavaDelegate{

    
    public static final String SERVICE_ACTION = "loanProcessorAction";
    
    Logger logger = Logger.getLogger(LoanProcessorActivity.class);
    
    @Autowired
    AmqpRpcClient amqpRpcClient;
    
    @Override
    public void execute(DelegateExecution execution) throws Exception {
	// TODO Auto-generated method stub
	logger.info("LoanProcessorActivity Started");
	
	 GsonBuilder gsonBuilder = new GsonBuilder();
		
	gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
	gsonBuilder.registerTypeAdapter(Date.class, new DateSerializer());
	Gson gson = gsonBuilder.setPrettyPrinting().create();
	
	LoanApplicationReqeust sc = (LoanApplicationReqeust) execution.getVariable(ProcessConstants.VAR_CTX);
	
	
	

	
	sc.setServiceName(ProcessConstants.SERVICE_NAME_LOANPROCESSOR);
	
	logger.info(String.format("LoanProcessor Request Payload [%s]", gson.toJson(sc)));
	
	logger.info("LoanProcessorActivity  Task completed\n\n");
	
	
    }

}
