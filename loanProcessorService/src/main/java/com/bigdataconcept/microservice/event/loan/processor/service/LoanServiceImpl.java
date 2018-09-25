package com.bigdataconcept.microservice.event.loan.processor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bigdataconcept.microservice.event.loan.processor.dao.LoanApplicationRepository;
import com.bigdataconcept.microservice.event.loan.processor.exception.LoanApplicationException;
import com.bigdataconcept.microservice.event.loan.processor.model.LoanApplication;

@Component
public class LoanServiceImpl implements LoanService{

    
    @Autowired
    LoanApplicationRepository loanApplicationRepository;
    
    @Override
    public List<LoanApplication> getAllApplication() {
	// TODO Auto-generated method stub
	List<LoanApplication> loanApps = new ArrayList<LoanApplication>();
        this.loanApplicationRepository.findAll().forEach(loanApps::add);
        return loanApps;
    }

    @Override
    public LoanApplication getLoanApplicationById(String id) throws LoanApplicationException {
	// TODO Auto-generated method stub
	LoanApplication loanApplication = null;
	try
	{
	    loanApplication = this.loanApplicationRepository.findById(id).get();
	}
	catch(Exception ex)
	{
	    if(ex instanceof NoSuchElementException)
	    {
		throw new LoanApplicationException("No Loan Application found With Id " + id);
	    }
	}
	return loanApplication;
    }

    @Override
    public LoanApplication saveOrUpdate(LoanApplication loanApplication) {
	
	// TODO Auto-generated method stub
             return this.loanApplicationRepository.save(loanApplication);
    }

    @Override
    public void delete(String id) {
	// TODO Auto-generated method stub
	this.loanApplicationRepository.deleteById(id);
    }

}
