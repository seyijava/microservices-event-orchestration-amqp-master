package com.bigdataconcept.microservice.event.loanfee.model;

public class LoanFee {

    private double  monthlyPayment = 0.0d;
    private int term;
    private double intrestRate = 0.0d;
    public double getMonthlyPayment() {
        return monthlyPayment;
    }
    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
    public int getTerm() {
        return term;
    }
    public void setTerm(int term) {
        this.term = term;
    }
    public double getIntrestRate() {
        return intrestRate;
    }
    public void setIntrestRate(double intrestRate) {
        this.intrestRate = intrestRate;
    }
}
