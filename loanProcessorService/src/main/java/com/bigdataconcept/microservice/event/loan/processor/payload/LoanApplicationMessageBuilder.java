package com.bigdataconcept.microservice.event.loan.processor.payload;

import com.bigdataconcept.microservice.event.loan.processor.model.LoanApplication;

public  class LoanApplicationMessageBuilder {

    private LoanApplicationMessageBuilder()
    {
	
    }
    public static class Builder
    {
	
	      public Builder(String  referenceNumber) {
	            this.referenceNumber = referenceNumber;
	        }

	    private String name;
	    private String surname;
	    private String SIN;
	    private String mobileNumber;
	    private String address;
	    private String city;
	    private String postalCode;
	    private String province;
	    private String referenceNumber;
	    
	 public Builder addName(String name)
	 {
	          this.name= name;
	          return this;
	 }
	 
	 
	 public Builder addProvince(String province)
	 {
	          this.province= province;
	          return this;
	 }
	 
	 public Builder addCity(String city)
	 {
	          this.city= city;
	          return this;
	 }
	 
	 
	 
	 public Builder addAddress(String address)
	 {
	          this.address = address;
	          return this;
	 }
	 
	 
	 public Builder addSurname(String surname)
	 {
	          this.surname= surname;
	          return this;
	 }
	 
	 public Builder addMobileNumber(String mobileNumber)
	 {
	          this.mobileNumber= mobileNumber;
	          return this;
	 }
	 
	 public Builder addSin(String sin)
	 {
	          this.SIN = sin;
	          return this;
	 }
	

	    public LoanApplication build(){
	        
		LoanApplication loanApp = new LoanApplication();  
	       
		return loanApp;
	    }
    }
    
    
}
