package com.bigdataconcept.microservice.event.process.controller;

import org.apache.log4j.Logger;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bigdataconcept.microservice.event.bpmn.loan.ProcessConstants;
import com.bigdataconcept.microservice.event.bpmn.loan.ProcessContext;

@RestController
@RequestMapping("/loanApp")
public class LoanApplciationController {

    
    Logger logger = Logger.getLogger(LoanApplciationController.class);
    
    @Autowired
    private ProcessEngine camunda;
    
         @RequestMapping(value = "/{scId}/submit", method = RequestMethod.POST)
	public ResponseEntity<?> submitLoanApp(@PathVariable("scId") String scId) {
		ProcessContext context = new ProcessContext();
		logger.info(String.format("Submit Loan Application Application Id [%s]",scId));
		
		submitLoanApplication(scId, context);
		if (context.getError() != null) {
			return new ResponseEntity<>(context.getError(), HttpStatus.FORBIDDEN);
		}

		return new ResponseEntity<>(context.getResponse(), HttpStatus.OK);

	}

	private ProcessInstance submitLoanApplication(String scId, ProcessContext context) {
	    
	    
		return camunda.getRuntimeService().startProcessInstanceByKey(//
				"submitLoanApp", 
				Variables .putValue(ProcessConstants.VAR_LR, scId).putValue(ProcessConstants.VAR_CTX, context));
		
		
		
	}
	
	
	
	
}
