package com.bigdataconcept.microservice.event.loan.processor.exception;

public class LoanApplicationException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
   
    public LoanApplicationException(String message)
    {
           super(message);
    }

}
