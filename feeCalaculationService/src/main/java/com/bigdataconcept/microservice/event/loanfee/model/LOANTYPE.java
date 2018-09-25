package com.bigdataconcept.microservice.event.loanfee.model;

public enum LOANTYPE {

    
    MORTGAGE("MORTGAGE"),PERSONAL("PERSONAL"),CARFINANCING("CARFINANCING");
    
    private String type;
    
    LOANTYPE(String type)
    {
	this.type = type;
    }
    
}
