package com.bigdataconcept.microservice.event.loanfee.model;

public class LoanFeeConfig {

    
    public LoanFeeConfig()
    {
	
    }
    
    public LoanFeeConfig(LOANTYPE loanType, int term, double interestRate)
    {
	
    }
    
    private LOANTYPE loanType;
    private double interestRate ;
    private int term;
    public LOANTYPE getLoanType() {
        return loanType;
    }
    public void setLoanType(LOANTYPE loanType) {
        this.loanType = loanType;
    }
    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    public int getTerm() {
        return term;
    }
    public void setTerm(int term) {
        this.term = term;
    }
}
