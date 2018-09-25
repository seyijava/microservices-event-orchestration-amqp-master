package com.bigdataconcept.microservice.event.data.model;

import java.io.Serializable;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

public class LoanApplication implements Serializable {

    /**
     * 
     */
    private CreditReport creditReport;
   
    private static final long serialVersionUID = 1L;
   
    
    private LoanFee loanFee;
    
    public LoanFee getLoanFee() {
        return loanFee;
    }
    public void setLoanFee(LoanFee loanFee) {
        this.loanFee = loanFee;
    }
    public CreditReport getCreditReport() {
        return creditReport;
    }
    public void setCreditReport(CreditReport creditReport) {
        this.creditReport = creditReport;
    }
    private String name;
    private String surname;
    private String SIN;
    private String mobileNumber;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getSIN() {
        return SIN;
    }
    public void setSIN(String sIN) {
        SIN = sIN;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    

}
