package com.bigdataconcept.microservice.event.data.model;

import java.io.Serializable;
import java.util.Date;

public class CreditReport implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int creditScore;
    private String referenceNumber;
    private Date transactionDate;
    private Date lastReportingDate;
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
}
