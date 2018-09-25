package com.bigdataconcept.microservice.event.creditBureau.service;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bigdataconcept.microservice.event.common.message.payload.CreditBureauRequest;
import com.bigdataconcept.microservice.event.common.message.payload.CreditBureauResponse;
import com.bigdataconcept.microservice.event.common.message.payload.MessageRequest;
import com.bigdataconcept.microservice.event.common.message.payload.MessageResponse;
import com.bigdataconcept.microservice.event.common.service.ServiceHandler;
import com.google.gson.Gson;
/**
 * 
 * @author Oluwaseyi Otun
 * The class implements Credit BureuService. It will typically 
 * invoke Remote Service expose by Credit Bureua Service via Restful  or Soap Webservice.
 * For simplicity we just generate credit score and return 
 * Applicant Credit Score
 *
 */

@Service("serviceHandler")
public class CreditBureauServiceHandler implements ServiceHandler<CreditBureauRequest> {

    
    Logger logger = Logger.getLogger(CreditBureauServiceHandler.class);
   
    
    @Override
    public MessageResponse processMessageRequestSync(String request) {
	// TODO Auto-generated method stub
         CreditBureauRequest creditBureauRequest = null;
         CreditBureauResponse creditBureauResponse = null;
	try {
	    
	    logger.info(String.format("Incoming Request Paylaod [%s]", request));
	    creditBureauRequest =   messageConverter(request);
	
	    creditBureauResponse = generateResponse();
	    creditBureauResponse.setLastReportingDate(new Date());
	    
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	logger.info(String.format("Service Response: %s ", creditBureauResponse));
	return Optional.ofNullable(generateResponse()).orElse(generateTimedoutResponse(creditBureauRequest));
	
	
    }

    @Override
    public void processMessageRequestAsync(String request) {
	// TODO Auto-generated method stub
	
    }
    
    
    
    private CreditBureauResponse generateTimedoutResponse(MessageRequest request) {
	CreditBureauResponse response =  new CreditBureauResponse();
		return response;
	}
    
   private CreditBureauResponse generateResponse()
   {
       int min = 1;
       int max = 10;
       int creditScore =   new Random().nextInt(max - min + 1) + min;
       CreditBureauResponse response = new CreditBureauResponse();
       response.setCreditScore(creditScore);
       response.setLastReportingDate(new Date());
       response.setTransactionDate(new Date());
       response.setReferenceNumber("CB-" + RandomStringUtils.randomAlphanumeric(10).toUpperCase());
       return response;
   }

@Override
public CreditBureauRequest messageConverter(String messageJson) {
    
   return  new Gson().fromJson(messageJson , CreditBureauRequest.class);
   
}
   

}
