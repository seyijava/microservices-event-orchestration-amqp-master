package com.bigdataconcept.microservice.event.bpmn.loan;

import java.text.DateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.bigdataconcept.microservice.event.amqp.adapter.producer.AmqpRpcClient;
import com.bigdataconcept.microservice.event.common.message.payload.CreditBureauRequest;
import com.bigdataconcept.microservice.event.common.message.payload.CreditBureauResponse;
import com.bigdataconcept.microservice.event.common.message.payload.DateDeserializer;
import com.bigdataconcept.microservice.event.common.message.payload.LoanApplicationReqeust;
import com.bigdataconcept.microservice.event.common.message.payload.MessageRequest;
import com.bigdataconcept.microservice.event.common.message.payload.MessageResponse;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * 
 * @author Oluwaseyi Otun
 * 
 * CreditBureau Activity this invoke 
 * This send the request to credit Bureau via the 
 * Amqp rpc adapter to invoke the CreditBureau Remote Service to verify
 * 
 * 
 *  
 *
 */
@Component("creditBureauService")
public class CreditBureauActivity implements JavaDelegate {

    public static final String SERVICE_ACTION = "creditBureauAction";
    
    Logger logger = Logger.getLogger(CreditBureauActivity.class);
    
    @Autowired
    AmqpRpcClient amqpRpcClient;
    
    
    
    @Override
    public void execute(DelegateExecution execution) throws Exception {
	// TODO Auto-generated method stub

	logger.info("CreditBureauActivity  Task Started");
	
	Gson gson = new GsonBuilder().setDateFormat(DateFormat.FULL).create();
	LoanApplicationReqeust sc = (LoanApplicationReqeust) execution.getVariable(ProcessConstants.VAR_CTX);
	

	
	
	CreditBureauRequest creditBureauRequest = new CreditBureauRequest();
	creditBureauRequest.setMobileNumber(sc.getMobileNumber());
	creditBureauRequest.setName(sc.getName());
	creditBureauRequest.setSIN(sc.getSIN());
	
	
	
	creditBureauRequest.setServiceName(ProcessConstants.SERVICE_NAME_CREDITBUREAU);
	creditBureauRequest.setServiceAction(SERVICE_ACTION);
	
	logger.info(String.format("Sending and Validating Credit Bureau Report ", execution.getCurrentActivityId()));
	
	logger.info(String.format("Credit Bureau Request Payload [%s] ", gson.toJson(creditBureauRequest)));
	
	MessageResponse messageResponse = (MessageResponse)amqpRpcClient.invokeService(creditBureauRequest);
	
	logger.info(String.format("Credit Bureau Response Payload [%s] ", gson.toJson(messageResponse)));
	
	if(messageResponse instanceof CreditBureauResponse)
	{
	    CreditBureauResponse creditResponse = (CreditBureauResponse)messageResponse;
	    sc.setCreditScore(creditResponse.getCreditScore());
	    sc.setLastReportingDate(creditResponse.getLastReportingDate());
	    sc.setReferenceNumber(creditResponse.getReferenceNumber());
	    execution.setVariable(ProcessConstants.VAR_CTX,sc);
	}
	else
	{
	    
	}
	logger.info("CreditBureauActivity  Completed\n\n");
    }

}
