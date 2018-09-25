package com.bigdataconcept.microservice.event.loan.processor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bigdataconcept.microservice.event.common.message.payload.LoanApplicationReqeust;
import com.bigdataconcept.microservice.event.loan.processor.model.LoanApplication;
import com.bigdataconcept.microservice.event.loan.processor.payload.LoanApplicationMessageBuilder;
import com.bigdataconcept.microservice.event.loan.processor.service.LoanService;

@Controller
@RequestMapping("/loan")
public class LoanController 
{

    
    @Autowired
    LoanService loanService;
    
    
    
    @RequestMapping(value = "/do" ,method = RequestMethod.POST)
    public void createLoanApplication(@RequestBody LoanApplicationReqeust loanApplicationRequest)
    {
	
	LoanApplication loanApp = new LoanApplicationMessageBuilder.Builder("")
		.addMobileNumber(loanApplicationRequest.getMobileNumber())
		.addName(loanApplicationRequest.getName())
		.addSin(loanApplicationRequest.getSIN())
		.addAddress(loanApplicationRequest.getAddress())
		.addCity(loanApplicationRequest.getCity())
		.addProvince(loanApplicationRequest.getProvince())
		.build();
		
	loanApp = this.loanService.saveOrUpdate(loanApp);
    }
    
    
    
    
    @RequestMapping(value = "/retrive/{id}", method = RequestMethod.GET)
    @ResponseBody
    public LoanApplication findApplicationById(@PathVariable("id") String id) {
	LoanApplication  loanApp = null;
	try
        {
	loanApp =  this.loanService.getLoanApplicationById(id);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
	return loanApp;
    }
    
    
    @RequestMapping(value = "/retriveAll", method = RequestMethod.GET)
    @ResponseBody
    public List<LoanApplication> findAllLoanApplication() {
        return this.loanService.getAllApplication();
    }
  
}
