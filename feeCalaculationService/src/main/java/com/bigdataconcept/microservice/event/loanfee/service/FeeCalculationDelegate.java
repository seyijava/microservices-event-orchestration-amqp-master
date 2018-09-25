package com.bigdataconcept.microservice.event.loanfee.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.bigdataconcept.microservice.event.common.message.payload.LoanFeeRequest;
import com.bigdataconcept.microservice.event.loanfee.model.LOANTYPE;
import com.bigdataconcept.microservice.event.loanfee.model.LoanFee;
import com.bigdataconcept.microservice.event.loanfee.model.LoanFeeConfig;

/**
 * 
 * @author Oluwaseyi Otun 
 * This class model Fee Calculation
 * The fee is calculated base on Loan Type 
 * For simplicity we use simple Interest Rate 
 * Calculation. 
 * In real world there might complex Fee Calcuation Service
 * implement In Complex Aglorith like R or Python 
 *
 */
@Component
public class FeeCalculationDelegate {

    
    Logger logger = Logger.getLogger(FeeCalculationDelegate.class);
    
    
     Map<String, LoanFeeConfig> loanFeeConfig = new HashMap<String,LoanFeeConfig>();
   
    /**
     * 
     * @param loanFeeRequest
     * @return
     */
    public LoanFee calcuateLoanFee(LoanFeeRequest loanFeeRequest)
    {
	logger.info("Calculate Loan Fee");
	    
	      LoanFeeConfig loanConfig =  loanFeeConfig.get(loanFeeRequest.getLoanType());
	   
	      
	      logger.info("Calculate Loan Fee" + loanConfig.getInterestRate());
	      double interestRate = loanConfig.getInterestRate() == 0.0 ? 2.5d :  loanConfig.getInterestRate();
	       
	    
	      double monthlyRate = interestRate / 12.0;
	       
	      // The length of the term in months 
	      // is the number of years times 12
	       
	      int termInMonths = loanConfig.getTerm() * 12;
	     
	      double monthlyPayment = (loanFeeRequest.getAmount()*interestRate) / (1-Math.pow(1+monthlyRate, -termInMonths));
	      LoanFee loanFee = new LoanFee();
	      loanFee.setIntrestRate(interestRate);
	      loanFee.setMonthlyPayment(monthlyPayment);
	      loanFee.setTerm(loanConfig.getTerm());
	return loanFee;
    }

   @PostConstruct
   public void init()
   {
       LoanFeeConfig mortageConfig = new LoanFeeConfig(LOANTYPE.MORTGAGE, 25,3.4d);
       LoanFeeConfig carFinaceConfig = new LoanFeeConfig(LOANTYPE.CARFINANCING, 6,3.6d);
       LoanFeeConfig personalConfig = new LoanFeeConfig(LOANTYPE.PERSONAL, 5,2.5d);
       loanFeeConfig.put(LOANTYPE.MORTGAGE.name(), mortageConfig);
       loanFeeConfig.put(LOANTYPE.CARFINANCING.name(), carFinaceConfig);
       loanFeeConfig.put(LOANTYPE.PERSONAL.name(), personalConfig);
   }
    
}
