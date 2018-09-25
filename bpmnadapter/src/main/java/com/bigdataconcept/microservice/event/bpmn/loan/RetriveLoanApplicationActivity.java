package com.bigdataconcept.microservice.event.bpmn.loan;

import org.apache.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bigdataconcept.microservice.event.common.message.payload.LoanApplicationReqeust;
import com.google.gson.Gson;


@Component("retriveLoanService")
public class RetriveLoanApplicationActivity implements JavaDelegate{

    
    public static final String SERVICE_ACTION = "retriveLoanApplicationAction";
    
    Logger logger = Logger.getLogger(RetriveLoanApplicationActivity.class);
    
    
    @Value("${loanServiceurl:http://localhost:9090/loan/retrive/}")
    String loanServiceurl;
    
    
    @Autowired
    RestTemplate restTemplate;
    
   
    
    @Override
    public void execute(DelegateExecution execution) throws Exception {
	
	logger.info("\n\n");
	
	logger.info("RetriveLoanApplicationActivity  Task Started");
	
	logger.info(String.format("RetriveLoanApplcation  from Redis", execution.getCurrentActivityId()));
	
	String loanId  = (String) execution.getVariable(ProcessConstants.VAR_LR);
	
	
	logger.info(String.format("Loan Application Id [%s]", loanId));
	
	
	ResponseEntity<LoanApplicationReqeust> response  = restTemplate.getForEntity(loanServiceurl + loanId, LoanApplicationReqeust.class);
	
	LoanApplicationReqeust loanAppRequest = response.getBody();
	
	logger.info(String.format("Loan Reqeust Details  Payload [%s]", new Gson().toJson(loanAppRequest)));
	
	execution.setVariable(ProcessConstants.VAR_CTX,loanAppRequest);
	
	
	logger.info("RetriveLoanApplicationActivity  Task completed\n\n");
    }

    
   
}
