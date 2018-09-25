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
import com.bigdataconcept.microservice.event.common.message.payload.LoanFeeRequest;
import com.bigdataconcept.microservice.event.common.message.payload.LoanFeeResponse;
import com.bigdataconcept.microservice.event.common.message.payload.MessageRequest;
import com.bigdataconcept.microservice.event.common.message.payload.MessageResponse;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



@Component("feeCalculationService")
public class FeeCaculatorActivity implements JavaDelegate {

 public static final String SERVICE_ACTION = "feeCalcAction";
    
  Logger logger = Logger.getLogger(FeeCaculatorActivity.class);
  
    
    @Autowired
    AmqpRpcClient amqpRpcClient;
    
    @Override
    public void execute(DelegateExecution execution) throws Exception {
	// TODO Auto-generated method stub
	logger.info("FeeCaculatorActivity  Task Started");
	Gson gson = new Gson();
	

	
	LoanApplicationReqeust sc = (LoanApplicationReqeust) execution.getVariable(ProcessConstants.VAR_CTX);
	
	logger.info(String.format("Incoming LoanApplicationReqeust [%s]", gson.toJson(sc)));
	
	
	
	
	
	LoanFeeRequest loanFeeRequest = new LoanFeeRequest();
	loanFeeRequest.setAmount(sc.getAmount());
	loanFeeRequest.setLoanType("MORTGAGE");
	loanFeeRequest.setTerm(5);
	loanFeeRequest.setServiceName(ProcessConstants.SERVICE_NAME_FEECALCULATION);
	loanFeeRequest.setServiceAction(SERVICE_ACTION);
	
	
	
	logger.info(String.format("Fee Calculation Request Payload [%s]", gson.toJson(loanFeeRequest)));
	
	
	MessageResponse messageResponse = (MessageResponse)amqpRpcClient.invokeService(loanFeeRequest);

	
	if(messageResponse instanceof LoanFeeResponse)
	{
	    LoanFeeResponse  loanFee =  (LoanFeeResponse)messageResponse;

          logger.info(String.format("Fee Calculation Response Payload [%s]", loanFee.getRate() + "| " + loanFee.getLoanFee()));
	    sc.setLoanFee(loanFee.getLoanFee());
	    sc.setRate(loanFee.getRate());
	    sc.setTerm(loanFee.getTerm());
	}
	else
	{
	      
	}
	
	logger.info("FeeCaculatorActivity  Completed\n\n");
	
    }

}
