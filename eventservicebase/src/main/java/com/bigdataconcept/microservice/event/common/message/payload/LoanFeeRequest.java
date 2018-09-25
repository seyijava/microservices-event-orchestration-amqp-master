package com.bigdataconcept.microservice.event.common.message.payload;

import java.io.Serializable;

public class LoanFeeRequest extends MessageRequest implements Serializable {

    
    private double amount;
    private int term;
    private String loanType;
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public int getTerm() {
        return term;
    }
    public void setTerm(int term) {
        this.term = term;
    }
    public String getLoanType() {
        return loanType;
    }
    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }
    
    
}
