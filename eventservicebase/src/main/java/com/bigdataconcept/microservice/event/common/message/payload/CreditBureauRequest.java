package com.bigdataconcept.microservice.event.common.message.payload;

import java.io.Serializable;

public class CreditBureauRequest extends MessageRequest implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
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
