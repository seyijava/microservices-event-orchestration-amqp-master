package com.bigdataconcept.microservice.event.common.message.payload;

public class LoanFeeResponse extends MessageResponse{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private double loanFee = 0.0d;
    private double rate = 0.0d;
    private int term;
    public double getLoanFee() {
        return loanFee;
    }
    public void setLoanFee(double loanFee) {
        this.loanFee = loanFee;
    }
    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
    public int getTerm() {
        return term;
    }
    public void setTerm(int term) {
        this.term = term;
    }
}
