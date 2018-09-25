package com.bigdataconcept.microservice.event.loan.processor.service;



import java.util.List;

import org.springframework.stereotype.Component;

import com.bigdataconcept.microservice.event.loan.processor.exception.LoanApplicationException;
import com.bigdataconcept.microservice.event.loan.processor.model.LoanApplication;


public interface LoanService {

    
    public List<LoanApplication> getAllApplication();
    
    public LoanApplication getLoanApplicationById(String id) throws LoanApplicationException;
    
    public LoanApplication saveOrUpdate(LoanApplication loanApplication);
    
    public void delete(String id);
    
    
      
      
}
