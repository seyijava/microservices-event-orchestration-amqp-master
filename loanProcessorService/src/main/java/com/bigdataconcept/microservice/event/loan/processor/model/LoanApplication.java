package com.bigdataconcept.microservice.event.loan.processor.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import com.bigdataconcept.microservice.event.common.message.payload.LoanApplicationReqeust;

@RedisHash("LoanApplication")
public class LoanApplication implements Serializable{

    
    public LoanApplication()
    {
	
    }
    
    
    private double amount;
    
    
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }


    private String address;
    private String city;
    private String postalCode;
    private String province;

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }


    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String id;
    
    
    @Id
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
    
    public int getCreditScore() {
        return creditScore;
    }
    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }
    public String getReferenceNumber() {
        return referenceNumber;
    }
    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
    public Date getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
    public Date getLastReportingDate() {
        return lastReportingDate;
    }
    public void setLastReportingDate(Date lastReportingDate) {
        this.lastReportingDate = lastReportingDate;
    }

    private int creditScore;
    private String referenceNumber;
    private Date transactionDate;
    private Date lastReportingDate;
    
    private double loanFee;
    private double rate;
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
