package com.bigdataconcept.microservice.event.loanfee.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bigdataconcept.microservice.event.common.message.payload.BaseResponse;
import com.bigdataconcept.microservice.event.common.message.payload.CreditBureauRequest;
import com.bigdataconcept.microservice.event.common.message.payload.ErrorMessageResponse;
import com.bigdataconcept.microservice.event.common.message.payload.LoanFeeRequest;
import com.bigdataconcept.microservice.event.common.message.payload.LoanFeeResponse;
import com.bigdataconcept.microservice.event.common.message.payload.MessageRequest;
import com.bigdataconcept.microservice.event.common.message.payload.MessageResponse;
import com.bigdataconcept.microservice.event.common.service.ServiceHandler;
import com.bigdataconcept.microservice.event.loanfee.model.LoanFee;
import com.google.gson.Gson;


/**
 * 
 * @author Oluwaseyi Otun 
 *
 */

@Component
public class FeeCalculationServiceHandler implements ServiceHandler<LoanFeeRequest> {

    static final Logger logger = Logger.getLogger(FeeCalculationServiceHandler.class);
    
    @Autowired
    FeeCalculationDelegate feeCalculationDelegate;
    
    @Override
    public MessageResponse processMessageRequestSync(String request) {
	// TODO Auto-generated method stub]
	logger.info(String.format("Incoming Reqeust [%s]", request));
	LoanFeeResponse loanFeeResponse = null ;
	LoanFeeRequest loanFeeRequest = null;
	try {
	     loanFeeRequest = this.messageConverter(request);
	    
	     LoanFee loanFee = this.feeCalculationDelegate.calcuateLoanFee(loanFeeRequest);
	     loanFeeResponse = new LoanFeeResponse();
	     logger.info("Loan Fee " + loanFee);
	     loanFeeResponse.setRate(loanFee.getIntrestRate());
	     loanFeeResponse.setTerm(loanFee.getTerm());
	     loanFeeResponse.setLoanFee(loanFee.getMonthlyPayment());
	    
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    logger.error(e);
	    ErrorMessageResponse errorMsg = new ErrorMessageResponse(e.getLocalizedMessage());
	  
	}
	
	logger.info(String.format("Service Response: %s ", loanFeeResponse));
	return loanFeeResponse;
	//return Optional.ofNullable(loanFeeResponse).orElse(generateTimedoutResponse(loanFeeRequest));
	
    }

    @Override
    public void processMessageRequestAsync(String request) {
	// TODO Auto-generated method stub
	
    }
    
    private LoanFeeResponse generateTimedoutResponse(MessageRequest request) {
	LoanFeeResponse response =  new LoanFeeResponse();
		return response;
	}

    @Override
    public LoanFeeRequest messageConverter(String messageJson) {
	return new Gson().fromJson(messageJson, LoanFeeRequest.class);
    }

}
